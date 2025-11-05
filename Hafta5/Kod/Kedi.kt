package com.example.hafta5

class Kedi
{
    // late -> gec,sonra
    // init -> initialize -> baslatma, baslangic
    lateinit var isim: String
    fun isim_ver()
    {
        this.isim = "Duman"
    }
}

fun main() {
    var k1 : Kedi = Kedi()
    k1.isim_ver()
    println(k1.isim)
}