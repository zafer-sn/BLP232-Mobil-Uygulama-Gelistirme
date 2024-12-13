package com.example.firebasefirestore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebasefirestore.databinding.ActivityMainBinding
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var gorunumBaglama : ActivityMainBinding
    private var kisiKoleksiyonReferansi = Firebase.firestore.collection("Kisiler")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gorunumBaglama = ActivityMainBinding.inflate(layoutInflater)
        val view = gorunumBaglama.root
        setContentView(view)
        gorunumBaglama.kaydetButton.setOnClickListener {
            var kisi = Kisi(
                gorunumBaglama.isimText.text.toString(),
                gorunumBaglama.soyisimText.text.toString(),
                gorunumBaglama.yasText.text.toString().toInt()
            ) // Kisi kisi = new Kisi();
            kisiEkle(kisi)
        }
        gercekZamanliVeriGetir()
        /*gorunumBaglama.veriGetirButton.setOnClickListener {
            verileriGetir()
        }*/

    }
    private fun gercekZamanliVeriGetir()
    {
        kisiKoleksiyonReferansi.addSnapshotListener { value, error ->

            error?.let {
                gorunumBaglama.uyariTextView.text = error.message.toString()
                return@addSnapshotListener
            }

            value?.let { ornek ->
                //var sorguIslemi = kisiKoleksiyonReferansi.get()
                var sb = StringBuilder()
                //var isimler = ""
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
            }


        }
    }


    // Kisi ekleme islemi
    /*
    * var birinci_deger = 15 -> snake_case
    * var birinciDeger = 25 -> camelCase
    * var BirinciDeger = 35 -> PascalCase
    * var sBirinciDeger = "selam" ->
    * */
    /*
    * Dispatchers.IO -> backend(arkaplanda) işlem yapacaksam verdiğim context
    * Dispatcher.Main -> frontend(önyüz) işlem yapacaksam vereceğim context
    *
    * */
    private fun kisiEkle(kisi : Kisi) = CoroutineScope(Dispatchers.IO).launch {
        try {
            kisiKoleksiyonReferansi.add(kisi).await()
            withContext(Dispatchers.Main)
            {
                gorunumBaglama.uyariTextView.text = "Kayit Başarılı!"
            }
        } catch (e: Exception)
        {
            println(e.stackTrace)
            withContext(Dispatchers.Main)
            {
                gorunumBaglama.uyariTextView.text = "Kayit Başarisiz!"
            }
        }
    }

    private fun verileriGetir() = CoroutineScope(Dispatchers.IO).launch {
        try {
            /*var sorguIslemi = kisiKoleksiyonReferansi
                .whereGreaterThan("yas", 20)
                .orderBy("yas", Query.Direction.DESCENDING)
                .get()
                .await()*/
            var sorguIslemi = kisiKoleksiyonReferansi.get().await()
            var sb = StringBuilder()
            //var isimler = ""
            for((index, dokuman) in sorguIslemi.documents.withIndex())
            {
                var kisi = dokuman.toObject(Kisi::class.java)
                sb.append("${index+1} $kisi \n")
                gorunumBaglama.ciktiTextView.text = sb.toString()
                // dokuman.toObject<Kisi>()
                // ORM(Object Relational Mapping)
                // isimler += dokuman.get("isim").toString()
                // gorunumBaglama.uyariTextView.text = isimler
            }
        } catch (e: Exception)
        {
            withContext(Dispatchers.Main)
            {
                gorunumBaglama.uyariTextView.text = "Hata bulundu"
                // gorunumBaglama.uyariTextView.text = e.message.toString()
            }
        }
    }

}