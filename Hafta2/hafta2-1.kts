// region Tür Dönüşümleri
// var -> variable -> Sonradan değişebilir
// val -> value -> Sonrada değişemez
var dolarKuru: String? = "27.8"
// println(dolarKuru!!.toDoubleOrNull()!! + 24.3)
var kurulusYili: Int = 1994
var kurulusYiliByte: Byte = kurulusYili.toByte()
println(kurulusYiliByte)
// var bilecikPlaka: Byte; [-128, 127] aralıkta atamaya izin verir.
// var deger = null
// var test:Any? = null
// endregion
// region Koşul Blokları
/* var gun: String = "Pazartesi"
when(gun.lowercase())
{
    "pazartesi" -> {
        var deger: Int = 10
        println(deger)
        println("1.Gun")
    }
    "sali" -> println("2. Gun")
    "carsamba" -> println("3. Gun")
    "persembe" -> println("4. Gun")
    "cuma" -> println("5. Gun")
    "cumartesi" -> println("6. Gun")
    "pazar" -> println("7. Gun")
    else -> println("Gun gecerli degil")
} */
// endregion
// region when2
// + -> Topla
// - Cikar
// * Carp
// / Bol
// && ve
// || veya
/* var girisYapildimi: Boolean = false
var yas: Int = 15
when
{
    (girisYapildimi == true && yas >= 18) -> {
        println("Yetkili kişi")
    }
    (girisYapildimi == false && yas >= 18) ->
    {
        println("Az yetkili kişi")
    }
    else -> {
        println("Yetkisiz kişi")
    }
} */
// endregion
// region If-Else
var vizeNotu: Int = 75
var odevNotu: Int = 35
var finalNotu: Int = 90
var ortalama: Double = (vizeNotu * 0.3) +
        (odevNotu * 0.2) +
        (finalNotu * 0.5)
println(ortalama)
if(ortalama < 50)
{
    println("FF ile kaldin")
} else if (ortalama >= 50 && ortalama < 60)
{
    println("DD aldin")
} else if (ortalama >= 60 && ortalama < 70)
{
    println("CC aldin")
} else if (ortalama >= 70 && ortalama < 80)
{
    println("BB aldin")
} else if (ortalama >= 80 && ortalama < 90)
{
    println("AB aldin")
} else
{
    println("AA aldin")
}
// endregion
// region Döngüler
println("Döngü-1")
for(i in 1..10)
{
    println(i)
}
println("Döngü-2")
for(i in 1..10 step 2)
{
    println(i)
}
println("Döngü-3")
for(i in 10 downTo 1 step 2)
{
    println(i)
}
// endregion
// region Fibonacci
// 1,1,2,3,5,8,13,21,..

var ilkDeger=1
println(ilkDeger)
var ikinciDeger=1
println(ikinciDeger)

for (i in 1..15){

    var ucuncuDeger=ilkDeger+ikinciDeger

    println(ucuncuDeger)
    ilkDeger=ikinciDeger
    ikinciDeger=ucuncuDeger
}
// endregion
// region Ornek-1
/* println("Ornek-1")
var standartBiletFiyati: Double = 120.0
var musteriYasBilgisiYok: Int? = null
// ?:
var yas: Int = musteriYasBilgisiYok ?: 5
var asilFiyat: Double = when
{
    (yas <= 12) -> (standartBiletFiyati * 0.5)
    // (yas >= 65) -> standartBiletFiyati * 0.7
    (yas >= 65) -> (standartBiletFiyati - (standartBiletFiyati*0.3))
    else -> (standartBiletFiyati)
}
println(asilFiyat) */
// endregion
// region Ornek-2
/* println("Faktoriyel Ornegi")
var deger: Int = 6
var sonuc:Int = 1
for (i in 2..deger)
{
    // 2
    //
    sonuc *= i // sonuc = sonuc * i
}
println(sonuc) */
// endregion
// region while Dongusu
/* println("While Döngüsü")
var sayac: Int = 1
while (sayac <= 10)
{
    println(sayac)
    sayac++;
}
for (i in 1..100)
{
    if (i == 50)
    {
        break
    }
    if (i % 2 == 0)
    {
        continue
    }
    println(i)
} */
// endregion
// region do while döngüsü
println("Do-While Döngüsü")
var sayac2: Int = 10
do {
    println(sayac2)
    sayac2++
} while (sayac2 < 100)
// endregion
// region Koleksiyonlar
println("Koleksiyonlar")
val yaslar = arrayOf<Any>(18, 21, 24, 32, "selam")
// yaslar = arrayOf(45, 65,34,23)
yaslar[0] = 34
println(yaslar[0])
println("Koleksiyon-2")
var sehirler = mutableListOf<String>("Bilecik", "Eskisehir", "Istanbul")
sehirler.add("Mersin")
sehirler.add(0, "Sanliurfa")
sehirler.forEach { sehir ->
    println(sehir)
}
println("ForEach")
var sayilar = mutableListOf<Int>(2, 7, 14, 21)
sayilar.forEach {
    println(it * 2)
}
// endregion
