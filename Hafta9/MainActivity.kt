package com.example.firestoreuygulama

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firestoreuygulama.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
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
            /*
            * Kisi classından k1 isminde bir referans değişken oluşturuyoruz
            * ve ilgili nesneyi işaret ediyoruz. İşaret ettiğimiz nesnenin
            * isim değeri önyüzdeki isimText id'sine sahip görünümden
            * soyisim değeri önyüzdeki soyisimText id'sine sahip görünümden
            * yas değeri önyüzdeki yasText id'sine sahip görünümden geliyor.
            * */
            var k1 = Kisi(
                gorunumBaglama.isimText.text.toString(),
                gorunumBaglama.soyisimText.text.toString(),
                gorunumBaglama.yasText.text.toString().toInt()
            ) // Kisi k1 = new Kisi();
            // kisiEkle() metodunu k1 referans değişkeni ile çağırıyoruz.
            kisiEkle(k1)
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
                gorunumBaglama.uyariText.text = "Kayit Başarılı!"
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