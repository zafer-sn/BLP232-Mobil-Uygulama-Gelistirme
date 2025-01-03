package com.example.hft12

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hft12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var filmListesi : ArrayList<Film>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val harrypotter = Film("Harry Potter", "30012000", 8, R.drawable.hp)
        val avatar = Film("Avatar", "300082007", 9, R.drawable.avatar)
        val cars = Film("Cars", "10071995", 7, R.drawable.cars)
        val yildizlararasi = Film("Yıldızlar Arası", "02062000", 10, R.drawable.yildizlararasi)
        filmListesi = arrayListOf(harrypotter, avatar, cars, yildizlararasi)

        val adapter = FilmAdapter(filmListesi)
        binding.filmListesiRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.filmListesiRecyclerView.adapter = adapter

    }
}