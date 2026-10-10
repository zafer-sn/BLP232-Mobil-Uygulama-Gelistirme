// region Değişkenler-2
// variable -> Değişken
var isim = "Zafer"
var soyisim = "Serin"
isim = "Ahmet"
// val -> value
val piSayisi = 3.14
// piSayisi = 2.718; -> Hata
var yas: Int = 30
// print() -> Bir alt satıra geçmez
// println("Benim yasim: ${yas}")
// Short, Byte, Long, Double, Float, Int
var aKarakteri: Char = 'A'
var kucukDeger: Byte = 120 // [-128, 127] aralığı
var karmasikDeger: Any = 33
// println((karmasikDeger as Int) + 11)
var miracYas: Int? = null
// println(miracYas!! + 5)
// println((miracYas ?: 18) + 5)
// var berkeYas = null -> Nothing?
// endregion
// region Tür Dönüşümleri
var dolarKuru: String = "47.8"
println(dolarKuru.toDouble() * 30)
var euroKuru: String = "50.1"
println((euroKuru.toDoubleOrNull() ?: 50.0) * 40)
var kurulusYili: Int = 1994
var kurulusYiliByte: Byte = kurulusYili.toByte()
println(kurulusYiliByte)
// endregion
// region Koşul Blokları
/* var gun: String = "sunday"
when(gun.lowercase())
{
    "pazartesi" -> {
        println("1. Gün")
        println("Selam")
        var deger: Int = 12
    }
    "sali" -> println("2. Gün")
    "carsamba" -> println("3. Gün")
    "persembe" -> println("4. Gün")
    "cuma" -> println("5. Gün")
    "cumartesi" -> println("6. Gün")
    "pazar" -> println("7. Gün")
    else -> println("Gecersiz Gün")
} */
var kullanici: String = "           Zafer    "
println(kullanici.trim())
/*
*+ -> Toplama
*- -> Cikarma
* % -> Mod Alma
* && -> ve
* || -> veya
* / -> Bolme
* */
var ehliyetYas: Int = 18
var ogrencimi: Boolean = false
var durum: Any = when
{
    ehliyetYas >= 18 && ogrencimi == true -> "Indirimden faydalanabilir"
    ehliyetYas <= 9 && ogrencimi == true -> "%30 Indirim"
    else -> 15
}
// println(durum)
var not: Int = 30
if(not < 50)
{
    println("FF ile kaldiniz.")
} else if(not >= 50 && not < 60)
{
    println("DD aldiniz.")
} else if(not >= 60 && not < 70)
{
    println("CC aldiniz.")
} else if(not >= 70 && not < 80)
{
    println("BB aldiniz.")
} else if(not >= 80 && not < 90)
{
    println("AB aldiniz.")
} else
{
    println("AA aldiniz.")
}
var vizeNotu: Int = 50
var odevNotu: Int = 80
var finalNotu: Int = 40
var ortalama: Double = (vizeNotu * 0.3) + (odevNotu * 0.2) + (finalNotu * 0.5)
var sonuc: String = when
{
    finalNotu < 50 -> "Kalir"
    ortalama >= 45 && finalNotu >= 50 -> "Geçer"
    else -> "Yanlis Kullanim"
}
println(sonuc)
// endregion
// region Döngüler
println("Döngü")
for(i in 1..10)
{
    println(i)
}
println("Döngü Artımlı")
for(i in 1..10 step 2)
{
    println(i)
}
println("Döngü Azaltımlı")
for(i in 10 downTo 1 step 2)
{
    println(i)
}
// 1,1,2,3,5,8,13 -> Fibonacci
var birinciDeger: Int = 1
println(birinciDeger)
var ikinciDeger: Int = 1
println(ikinciDeger)
for(i in 1..10)
{
    var ucuncuDeger:Int = birinciDeger + ikinciDeger
    println(ucuncuDeger)
    birinciDeger = ikinciDeger
    ikinciDeger = ucuncuDeger
}
// endregion
