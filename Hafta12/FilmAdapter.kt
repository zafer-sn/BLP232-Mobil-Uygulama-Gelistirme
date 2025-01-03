package com.example.hft12

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hft12.databinding.ActivityMainBinding
import com.example.hft12.databinding.RecyclerRowBinding
// Interface -> Abstract class
// Nested class
// Class'tan kalıtım alınır, Interfaceten implemente edilir
class FilmAdapter(val filmListesi: ArrayList<Film>) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>()
{
    class FilmViewHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return filmListesi.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.binding.sablonTextView.text = filmListesi[position].isim

        holder.itemView.setOnClickListener {
            //holder.itemView.context
            val intent = Intent(holder.binding.root.context, DetayActivity::class.java)
            val secilenFilm = intent.putExtra("secilenFilm", filmListesi[position])
            holder.itemView.context.startActivity(intent)
        }


    }
}





