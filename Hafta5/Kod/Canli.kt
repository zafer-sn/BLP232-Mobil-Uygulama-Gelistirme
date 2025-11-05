package com.example.hafta5

class Canli
{
    // var isim: String? = null
    var isim: String? = "Zafer"
}

fun main() {
    var c1 : Canli = Canli()
    //println(c1.isim!!.length)
    // println(c1.isim?.length)
    c1.isim?.let {
        println("Deger null degil")
        println(c1.isim?.length)
    }
}

