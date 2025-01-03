package com.example.hft12

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hft12.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        //val view = binding.root
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adapterdenGelenIntent = intent
        val secilenFilm = adapterdenGelenIntent.getSerializableExtra("secilenFilm") as Film
        binding.filmIsimtextView.text = secilenFilm.isim
        binding.filmTarihtextView.text = secilenFilm.tarih
        binding.filmPuantextView.text = secilenFilm.puan.toString()
        binding.filmGorselImage.setImageResource(secilenFilm.gorsel)



    }
}