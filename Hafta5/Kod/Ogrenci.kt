package com.example.hafta5

class Ogrenci
{
    var isim: String = "" // Kotlin'de public, C#'ta private
    var soyisim: String = ""
    var yas:Int = 0
    var cinsiyet: Boolean = false
    var boy: Double = 0.0
    fun okula_git()
    {
        println("Okula gidiliyor...")
    }
    fun ders_calis()
    {
        println("Ders calisiliyor...")
    }

    companion object
    {

    }
    fun not_hesapla(vize_notu:Int, final_notu:Int) : Double
    {
        return vize_notu*0.4+final_notu*0.6
    }
}

fun main() {
    /*var o1 : Ogrenci = Ogrenci()
    o1.isim = "Reyhan"
    println(o1.not_hesapla(55,85))

    var o2 : Ogrenci = Ogrenci()
    o1.isim = "Ozlem"
    println(o1.not_hesapla(65,75))*/
    //println(Ogrenci.not_hesapla(24, 65))
    /* Ogrenci().not_hesapla(45, 75)
    Ogrenci().not_hesapla(65, 85)
    Ogrenci().not_hesapla(65, 85)
    Ogrenci().not_hesapla(65, 85)
    Ogrenci().not_hesapla(65, 85)
    Ogrenci().not_hesapla(65, 85) */
}