// region while
println("while")
var sayac: Int = 0
while(sayac < 10)
{
    println(sayac)
    sayac++ // sayac = sayac + 1 veya sayac += 1
}
// endregion
// region do-while
println("do-while")
var sayac2 : Int = 0
do {
    println(sayac2)
} while(sayac2 >= 1000)
// endregion
// region Koleksiyonlar
println("Koleksiyonlar - Veri Yapıları")
var ogrenciYaslar = arrayOf<Int>(19, 20, 21, 18, 23, 22)
println(ogrenciYaslar)
println(ogrenciYaslar[0])
// ogrenciYaslar[3] = 10
ogrenciYaslar.set(3, 25)
println(ogrenciYaslar[3])
println("for-each")
ogrenciYaslar.forEach { eleman ->
    // it - iterasyon
    println(eleman)
}
// Object - Any
var sayilar = arrayOf<Any>(100, "201", 203.4)
// println(sayilar[0] + 11) - as operatörü
// endregion
// region Koleksiyonlar2
println("MutableList")
var kurulusYillari = mutableListOf<Int>(1994, 2007, 2000)
kurulusYillari.add(2010) // 1994, 2007, 2000, 2010
kurulusYillari.add(0, 2003) // 2003, 1994, 2007, 2000, 2010
// delete, remove
kurulusYillari.remove(2007)
println("Duz son liste")
kurulusYillari.forEach {
    println(it)
}
println("Liste boyutu")
println(kurulusYillari.size)
// turn, reverse
println("Ters son liste")
kurulusYillari.reverse()
kurulusYillari.forEach {
    println(it)
}
println("Karıştırılmış liste")
kurulusYillari.shuffle()
kurulusYillari.forEach {
    println(it)
}
println("Set veri yapıları")
var dogumYillari = mutableSetOf<Int>(2004, 2009, 2007, 2007, 2006, 2006, 2006)
// println(dogumYillari[0]) - Bu şekilde ulaşılamaz
println(dogumYillari.contains(2004))
dogumYillari.forEach {
    println(it)
}
println("Map veri yapıları")
// Json - Javascript object notation
var isimYas = mutableMapOf<String, Int>("userId" to 1, "Zafer" to 30, "Ahmet" to 20, "Kubra" to 19)
println(isimYas["userId"])
println(isimYas["Zafer"])
println(isimYas.keys)
isimYas.keys.forEach {
    println(it)
}
println(isimYas.values)
println("Map Of - 2")
isimYas["id"] = 1
println(isimYas)
// println(isimYas[1]) - Hata
// endregion
// region Fonksiyonlar
// function - Fonksiyon
fun selamla()
{
    println("Selam")
}
selamla()
selamla()
selamla()
selamla()
fun AsalSayiBul(sayi: Int) : Boolean
{
    if(sayi < 2)
    {
        return  false
    }
    var gelenSayiAsalmi : Boolean = true
    for(i in 2..sayi-1)
    {
        if(sayi % i == 0)
        {
            gelenSayiAsalmi = false
            break
        }
    }
    return gelenSayiAsalmi
}
// var sayi = 5
// var sayi = 10
println("Asal")
println(AsalSayiBul(11)) // true
println(AsalSayiBul(3)) // true
println(AsalSayiBul(9)) // false
println(AsalSayiBul(15)) // false
println("Negatifler")
println(AsalSayiBul(-5)) // false
// Özyinelemeli fonksiyon
fun Faktoriyel(sayi: Int) : Int
{
    if(sayi < 0)
    {
        throw Exception("Negatif faktoriyel olamaz!")
    }
    if(sayi == 0)
    {
        return 1
    }
    return  sayi * Faktoriyel(sayi-1)
}
try {
    println(Faktoriyel(5))
    println(Faktoriyel(0))
    println(Faktoriyel(-5))
} catch (e: Exception)
{
    println("Hata meydana geldi!")
}

// Faktoriyel(5) // 5 * 4 * 3 * 2 * 1 * 0 * -1 Fakrotiyel(-2)

// endregion
// region Uygulama-2
println("Uygulama-2")
var uygulamaListe = mutableListOf<Any>()
for (i in 2500..5000)
{
    if(i % 2 == 0)
    {
        uygulamaListe.add(i)
    }
}
for(i in 0..uygulamaListe.size-1)
{
    if((uygulamaListe[i] as Int) % 5 == 0)
    {
        uygulamaListe[i] = "kullanici"
    }
}
println("Son hali")
uygulamaListe.forEach {
    println(it)
}
// endregion