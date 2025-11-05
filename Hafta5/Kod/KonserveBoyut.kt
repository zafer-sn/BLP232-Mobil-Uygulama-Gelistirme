package com.example.hafta5
// enum -> enumerate -> numaralandirma
enum class KonserveBoyut
{
    KUCUK, ORTA, BUYUK
}

fun main() {
    fiyat_hesapla(350, KonserveBoyut.KUCUK)
}

fun fiyat_hesapla(adet:Int, boyut: KonserveBoyut)
{
    when(boyut)
    {
        KonserveBoyut.KUCUK -> println("Toplam fiyat: ${adet * 30}")
        KonserveBoyut.ORTA -> println("Toplam fiyat: ${adet * 60}")
        KonserveBoyut.BUYUK -> println("Toplam fiyat: ${adet * 90}")
        else -> println("Hicbiri degil")
    }
}