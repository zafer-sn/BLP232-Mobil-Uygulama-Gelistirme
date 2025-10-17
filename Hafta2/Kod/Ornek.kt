package com.example.kotlindersleribp.giris

// main fonksiyonu tanimlanmasi
fun main() {
    // Bir alt satira gecmeyen ve ekrana yazi yazdiran kod
    print("Merhaba Kotlin!")
    // Bir alt satira gecen ve ekrana yazi yazdiran kod
    println("Merhaba Dunya!")
    // Tek satirli yorum satiri
    /* Cok
    * satirli
    * yorum
    * satiri */
    // Degisken tanimlama
    var yas = 30
    yas = 50
    // String icerisinde degisken degeri yazdirma
    println("Benim yasim: ${yas}")

    val pi_sayisi = 3.14
    // pi_sayisi = 2.718 -> HATA! val ile tanimlanan degiskenin degeri derleme zamaninda degistirilemez!

    // Degisken turu belirterek degisken tanimlama
    var bilecik_plaka : Int = 11
    print("Lutfen sayi giriniz..:")
    // Komut satirindan girdi alma ve integera cevirme
    var sayi1 = readln().toInt()
    print("Lutfen sayi giriniz..:")
    var sayi2 = readln().toInt()
    println(sayi1 + sayi2)

    var bas_harf : Char = 'Z'
    var e_sayisi : Float = 2.5f

    // Ornek-2
    val urun_id : Int = 3416
    var urun_adi : String = "Macbook Pro"
    var urun_adet : Int = 100
    var urun_fiyat : Int = 42999
    var urun_tedarikci : String = "Apple"

    // Tur donusumleri - kucuk degerden buyuge cevrimde veri kaybi olabilir!
    var istanbul_plaka : Byte = 34
    var istanbul_plaka_i : Int = istanbul_plaka.toInt()

    var kurulus_yili : Int = 1994
    var kurulus_yili_b : Byte = kurulus_yili.toByte()

    var deger : String = "3.14selam"
    // Double donusumu basarili olursa degeri, basarisiz olursa null dondurur
    var deger_d = deger.toDoubleOrNull()

    println(deger_d)

    print("Kilonuzu giriniz..:")
    var kilo : Double = readln().toDouble()
    print("Boyunuzu giriniz..:")
    var boy : Double = readln().toDouble()
    var vki : Double = kilo / (boy * boy)
    println(vki)

    var vize_notu : Int = 100
    var odev_notu : Int = 100
    var final_notu : Int = 90
    var ortalama : Double = (vize_notu * 0.3) + (odev_notu * 0.1) + (final_notu * 0.6)
    // if-else bloklari
    if (ortalama > 90)
    {
        println("Harf notunuz: AA")
    } else if (ortalama > 80)
    {
        println("Harf notunuz: BB")
    } else
    {
        println("Harf notunuz: FF")
    }

    // when yapisi
    var gun = 3
    when(gun)
    {
        1 -> println("Pazartesi")
        2 -> println("Sali")
        3 -> {
            println("Deneme")
            println("Carsamba")}
        4 -> println("Persembe")
        5 -> println("Cuma")
        6 -> println("Cumartesi")
        7 -> println("Pazar")
        else -> println("Ornek")
    }

    // for dongusu
    for (i in 10 downTo 1 step 2)
    {
        println(i)
    }

    // faktoriyel hesabi
    print("Faktoriyelini hesaplamak istediginiz degeri giriniz..:")
    var sayi = readln().toInt()
    var f = 1
    for (i in 1..sayi)
    {
        f = f * i
    }
    println("${sayi}! = ${f}")

    // Fibonacci serisi -> 0 1 1 2 3 5 8 13 ..
    println("Fibonacci serisi asagidaki sekildedir...")
    var eleman1 = 0
    println(eleman1)
    var eleman2 = 1
    println(eleman2)
    for (i in 1..20)
    {
        var eleman3 = eleman1 + eleman2
        println(eleman3)
        eleman1 = eleman2
        eleman2 = eleman3
    }
}