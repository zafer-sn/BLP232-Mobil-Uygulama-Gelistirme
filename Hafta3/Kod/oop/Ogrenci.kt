package com.example.kotlindersleri.oop
// primary constructor
class Ogrenci (var isim: String, var soyisim: String, var yas: Int)
{
    // init -> initalize -> baslatmak
    init {
        println("Ogrenci nesnesi olusturuldu...")
    }

    init {

    }
    // Metot - class içerisindeki fonksiyonlara metot denir
    // Yapici metot - constructor
    // Secondary constructor
    /* constructor(isim: String, soyisim: String, yas:Int)
    {
        println("Ogrenci nesnesi olusturuldu...")
    } */
    // Once primary constructor atamalari yapilir
    // Sonra yukaridan asagiya dogru initler calisir
    // Daha sonra secondary constructor calisir
}

fun main() {
    var ogr1 = Ogrenci("Eyup", "Test", 20)
    var ogr2 = Ogrenci("Abdullah", "Deneme", 21)
    var ogr3 = Ogrenci("Berra", "Ornek", 22)


    /* var ogr1 = Ogrenci() // Ogrenci ogr1 = new Ogrenci();
    ogr1.isim = "Eyup"
    ogr1.soyisim = "Test"
    ogr1.yas = 20
    var sayi : Int = 15
    var ogr2 : Ogrenci  = Ogrenci() // Stack-Heap

    var bilecik_plaka = 11
    var istanbul_plaka = 34
    bilecik_plaka = istanbul_plaka //34 - bp
    istanbul_plaka = 1 // 1 - ip
    println(bilecik_plaka)
    println(istanbul_plaka)

    var eyup = Ogrenci()
    eyup.isim = "Eyup"
    var abdullah = Ogrenci()
    abdullah.isim = "Abdullah"
    eyup = abdullah
    eyup.isim = "Ahmet"
    println(abdullah.isim)
    println(eyup.isim) */
}