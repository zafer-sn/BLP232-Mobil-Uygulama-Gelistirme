package com.example.firestoreuygulama

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firestoreuygulama.databinding.ActivityMainBinding
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    // GorunumBaglama(ViewBinding) yapabilmek için gereken değişken
    private lateinit var gorunumBaglama: ActivityMainBinding
    // Firebase'in Firestore databaseine erişmek için kullanacağımız değişken
    private var kisiKoleksiyonReferansi = Firebase.firestore.collection("Kisiler")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // gorunumBaglama değişkenine front end tarafındaki layoutu atıyoruz
        gorunumBaglama = ActivityMainBinding.inflate(layoutInflater)
        /*
        * gorunum diye bir değişken tanımlayıp buna layoutun kök(root)
        * yapısını(bu da Constraint Layout'tur) atıyoruz
        * */
        val gorunum = gorunumBaglama.root
        // İçeriği atadığımız değişken ile değiştiriyoruz.
        setContentView(gorunum)
        // id'si kaydetButton olan butona tıklandığı zaman çalışacak kod
        gorunumBaglama.kaydetButton.setOnClickListener {
            // k1 referans değişkenine eskiKisiyiGetir() metodundan dönen kişiyi atıyoruz
            var k1 = eskiKisiyiGetir()
            // kisiEkle metodunu k1 referans değişkenini parametre olarak yollayıp çağırıyoruz
            kisiEkle(k1)
        }
        // guncelleButton id sine sahip butona tıklandığında çalışacak metot
        gorunumBaglama.guncelleButton.setOnClickListener {
            // eskiKisi değişkenine eskiKisiyiGetir() metotundan dönen değeri atıyoru
            val eskiKisi = eskiKisiyiGetir()
            // yeniKisiSozlugu değişkenine yeniKisiSozluguGetir() metotundan dönen değeri atıyoruz
            val yeniKisiSozlugu = yeniKisiSozluguGetir()
            // kisiGuncelle metotunu eskiKisi ve yeniKisiSozlugu parametreleri ile çağırıyoruz.
            kisiGuncelle(eskiKisi, yeniKisiSozlugu)
        }

        // id si silButton olan butona tıklandığında yapılacak işlemler
        gorunumBaglama.silButton.setOnClickListener {
            // silinecekKisi değişkenine eskiKisiyiGetir() metotundan dönen değeri atıyoruz.
            var silinecekKisi = eskiKisiyiGetir()
            // kisiSil metotunu silinecekKisi parametresi ile çağırıyoruz
            kisiSil(silinecekKisi)
        }

        /*gorunumBaglama.veriGetirButton.setOnClickListener {
            verileriGetir()
        }*/
        // Verileri gercek zamanli olarak guncellemek için gerekli metot
        verileriGercekZamanliGuncelle()
    }
    // kisiSil metodu silinecek kisi için bir kisi parametresi alıyor.
    // Asenkron bir şekilde çalışıyor ve Dispatcher.IO olduğu için backend işlemleri yapıyor.
    private fun kisiSil(kisi: Kisi) = CoroutineScope(Dispatchers.IO).launch {
        // Koleksiyondaki isim değeri parametreden gelen isime
        // Koleksiyondaki soyisim değeri parametreden gelen soyisime
        // Koleksiyondaki yas değeri parametreden gelen yasa
        // eşit olan kullanıcı getiriliyor ve await() ile bekleniyor
        val kisiSorgu = kisiKoleksiyonReferansi
            .whereEqualTo("isim", kisi.isim)
            .whereEqualTo("soyisim", kisi.soyisim)
            .whereEqualTo("yas", kisi.yas)
            .get()
            .await()
        // kisiSorgu'nun documents ları boş değilse çalışacak kod bloğu
        if (kisiSorgu.documents.isNotEmpty())
        {
            // işlemi yapmayı deniyoruz hata varsa catch ile yakalıyoruz
            try {
                for (doc in kisiSorgu)
                {
                    // bulduğumuz kişiye id si ile ulaşıp siliyoruz
                    kisiKoleksiyonReferansi.document(doc.id).delete()
                    /*kisiKoleksiyonReferansi.document(doc.id).update(
                        mapOf("isim" to FieldValue.delete(), "soyisim" to FieldValue.delete(), "yas" to FieldValue.delete())
                    )*/
                }
            } catch (e: Exception)
            {
                // Front-end kısmında yani arayüzde işlem yapacağımız için contexti Dispatcher.Main yapıyoruz ve ekrana bir uyarı yazdırıyoruz
                withContext(Dispatchers.Main)
                {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
                }
            }

        }
        else
        {
            withContext(Dispatchers.Main)
            {
                Toast.makeText(this@MainActivity, "Sorgu sonucu kimse getirilemedi!", Toast.LENGTH_LONG).show()
            }
        }
    }
    // kisi guncellemek için kullanılacak metot
    private fun kisiGuncelle(kisi: Kisi, guncellenecekKisi: Map<String, Any>) = CoroutineScope(Dispatchers.IO).launch {
        val kisiSorgu = kisiKoleksiyonReferansi
            .whereEqualTo("isim", kisi.isim)
            .whereEqualTo("soyisim", kisi.soyisim)
            .whereEqualTo("yas", kisi.yas)
            .get()
            .await()
        if (kisiSorgu.documents.isNotEmpty())
        {
            try {
                for (doc in kisiSorgu)
                {
                    // Bulduğumuz kişinin bilgilerini sozlukteki bilgilerle güncelliyoruz
                    // SetOptions.merge() kullanılmazsa örneğin sadece isim değeri girildiğinde
                    // soyisim ve yas değerlerini siler! Bunu istemediğimiz için sadece girdiğimiz
                    // değer değişsin istediğimiz için merge ile birleştiriyoruz
                    kisiKoleksiyonReferansi.document(doc.id).set(
                        guncellenecekKisi,
                        SetOptions.merge()
                    )
                }
            } catch (e: Exception)
            {
                withContext(Dispatchers.Main)
                {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
                }
            }

        }
        else
        {
            withContext(Dispatchers.Main)
            {
                Toast.makeText(this@MainActivity, "Sorgu sonucu kimse getirilemedi!", Toast.LENGTH_LONG).show()
            }
        }
    }
    // Eski kisiyi getirecek metot
    private fun eskiKisiyiGetir() : Kisi
    {
        val isim = gorunumBaglama.isimText.text.toString()
        val soyisim = gorunumBaglama.soyisimText.text.toString()
        val yas = gorunumBaglama.yasText.text.toString().toInt()
        val kisi = Kisi(isim, soyisim, yas)
        return kisi
    }

    //yeni kisiyi getirecek metot
    private fun yeniKisiSozluguGetir() : Map<String, Any>
    {
        val yIsim = gorunumBaglama.yeniIsimText.text.toString()
        val ySoyisim = gorunumBaglama.yeniSoyisimText.text.toString()
        val yYas = gorunumBaglama.yeniYasText.text.toString()
        /*Int32 -> 4 bayt
        Int16 -> short -> 2 bayt
        Int64 -> long -> 8 bayt

        mapOf -> verileri sabit değiştirilemez!
        hashMapOf -> verileri değiştirilebilir ama veriler sırasız
        mutableMapOf -> verileri değiştirilebilir ve veriler sırasız

        val m1 = mapOf("isim" to "Zafer", "yas" to 29)
        val m2 = hashMapOf("isim" to "Zafer", "yas" to 29)
        val m3 = mutableMapOf("isim" to "Zafer", "yas" to 29)*/
        val map = mutableMapOf<String, Any>()

        if (yIsim.isNotEmpty())
        {
            map["isim"] = yIsim
        }

        if (ySoyisim.isNotEmpty())
        {
            map["soyisim"] = ySoyisim
        }

        if (yYas.isNotEmpty())
        {
            map["yas"] = yYas.toInt()
        }

        // key-value
        /*var isimler = mapOf<String, Int>("isim" to true, "yas" to 29)
        isimler["yas"]*/
        return map
    }

    //verileri gercek zamanlı olarak güncellemek
    private fun verileriGercekZamanliGuncelle()
    {
        kisiKoleksiyonReferansi.addSnapshotListener { value, error ->
            error?.let {
                gorunumBaglama.uyariText.text = "Hata var!"
                return@addSnapshotListener
            }

            value?.let {
                // var sorguIslemi = kisiKoleksiyonReferansi.get()
                var sb = StringBuilder() // var b1 = Bitki()
                it.forEach {
                    // ORM(Object Realitional Mapping)
                    //sb.append(it.toObject<Kisi>().toString()
                    sb.append("${it.toObject(Kisi::class.java)} \n")
                    gorunumBaglama.veriGetirTextView.text = sb.toString()
                }
                /*
                for((index, dokuman) in ornek.withIndex())
                {
                    var kisi = dokuman.toObject(Kisi::class.java)
                    sb.append("${index+1} $kisi \n")
                    gorunumBaglama.ciktiTextView.text = sb.toString()
                    // dokuman.toObject<Kisi>()
                    // ORM(Object Relational Mapping)
                    // isimler += dokuman.get("isim").toString()
                    // gorunumBaglama.uyariTextView.text = isimler
                }
                * */
            }
        }
    }

    // verileri getirecek metot
    private fun verileriGetir() = CoroutineScope(Dispatchers.IO).launch {
        try {
            /*var sorguIslemi = kisiKoleksiyonReferansi
                .whereLessThan("yas", 25)
                .whereGreaterThan("yas", 17)
                .orderBy("yas", Query.Direction.DESCENDING)
                .get()
                .await()*/
            var sorguIslemi = kisiKoleksiyonReferansi.get().await()
            //sorguIslemi.documents
            // var meyveler = arrayListOf("elma", "armut", "cilek")
            var sb = StringBuilder() // var b1 = Bitki()
            sorguIslemi.documents.forEach {
                // ORM(Object Realitional Mapping)
                //sb.append(it.toObject<Kisi>().toString()
                sb.append("${it.toObject(Kisi::class.java)} \n")
                gorunumBaglama.veriGetirTextView.text = sb.toString()
            }

            //gorunumBaglama.uyariText.text = sorguIslemi.toString()
        } catch (e: Exception)
        {
            withContext(Dispatchers.Main)
            {
                gorunumBaglama.uyariText.text = e.message.toString()
            }
        }
    }

    /*Process, Thread, asyncio, Coroutine, Future
    Backend arka-yüz Dispatchers.IO
    Frontend ön-yüz için Dispatchers.Main contextini kullanıyoruz*/
    // kisiEkle metodu asenkron çalışıyor.
    private fun kisiEkle(kisi: Kisi) = CoroutineScope(Dispatchers.IO).launch {
        // try-catch bloğu ile ilgili işlemi deniyoruz.
        try {
            // kisiKoleksiyonReferansina ilgili classı ekliyoruz ve bekliyoruz
            kisiKoleksiyonReferansi.add(kisi).await()
            // Kayıt başarılı ise arayüzde "Kayit Başarılı!" textini gösteriyoruz.
            withContext(Dispatchers.Main)
            {
                //gorunumBaglama.uyariText.text = "Kayit Başarılı!"
                Toast.makeText(this@MainActivity, "Kayıt Başarılı!", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception)
        {
            // Kayıt başarısız ise arayüzde "Kayit Başarısız!" textini gösteriyoruz.
            withContext(Dispatchers.Main)
            {
                gorunumBaglama.uyariText.text = "Kayit Başarısız!"
            }
        }
    }

}