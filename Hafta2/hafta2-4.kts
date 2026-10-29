var sayac: Int = 1
while(sayac <= 10)
{
    println(sayac)
    sayac++
}
var i: Int = 1
do {
    println(i)
    i++
} while (i > 1000)
var sayilar: MutableList<Int> = mutableListOf<Int>(22, 33, 44, 55)
var sayilar2 = mutableSetOf<String>("Zafer", "Zafer", "zafer", "ahmet")
var anahtarDeger = mutableMapOf<String, String>("isim" to "Zafer", "soyisim" to "Serin")
println(anahtarDeger["isim"])
fun selamla()
{
    println("Merhaba")
}
fun asalSayiBul(sayi: Int) : Boolean
{
    if (sayi < 2)
    {
        return  false
    }
    var asalMi : Boolean = true
    for (i in 2..sayi-1)
    {
        if(sayi % i == 0)
        {
            asalMi = false
            break
        }
    }
    return  asalMi
}
println(asalSayiBul(25))
println(asalSayiBul(11))
println(asalSayiBul(17))
println(asalSayiBul(41))
println(asalSayiBul(-5))

fun faktoriyel(sayi: Int) : Int
{
    if (sayi < 0)
    {
        throw Exception("Negatif faktoriyel olamaz")
    }
    if (sayi == 0)
    {
        return  1
    }
    return sayi * faktoriyel(sayi -1)
}
try {
    println(faktoriyel(5))
    println(faktoriyel(7))
    println(faktoriyel(2))
    println(faktoriyel(1))
    println(faktoriyel(0))
    println(faktoriyel(-5))
    println(faktoriyel(-7))
} catch (e: Exception)
{
    println("Hata alindi!")
}
class Personel
{
    var isim: String = ""
    var yas: Int = 0
    var brutGelir: Double = 0.0
    var kesintiler: Double = 0.0
    fun MaasHesapla() : Double
    {
        return brutGelir-kesintiler;
    }
    constructor(isim: String, yas: Int)
    {
        println("Personel nesnesi olusturuldu!")
        this.isim = isim
        this.yas = yas
    }
    constructor()
    {

    }
}
var p1: Personel = Personel()
p1.isim = "Ahmet"
p1.yas = 30
p1.brutGelir = 50000.0
p1.kesintiler = 10000.0
println(p1.MaasHesapla())

var p2: Personel = Personel("Mehmet", 42)
println(p2.isim)
println(p2.yas)
p2.brutGelir = 70000.0
p2.kesintiler = 20000.0
println(p2.MaasHesapla())
class Ogrenci (var isim: String, var yas: Int)
{

}
var o1 = Ogrenci("Kubra", 20)
var o2 = Ogrenci("Ahmet", 19)
var bilecikPlaka: Int? = null
bilecikPlaka?.let {
    println(it * 2)
}
class Ornek
{
}
open class Test
{
    var deger: Int = 0
}

class Musteri
{
    private var bakiye: Int = 0
    fun GetBakiye() : Int
    {
        return this.bakiye;
    }
    fun SetBakiye(gelenDeger: Int)
    {
        this.bakiye = gelenDeger
    }

    var krediNotu: Int = 0
        get(){
            return field
        }
        set(value){
            field = value
        }
}
var musteri1:Musteri = Musteri()
musteri1.SetBakiye(2500)
println(musteri1.GetBakiye())
musteri1.krediNotu


open class Calisan (var isim: String, var soyisim: String)
{

}
class Stajyer(isim: String, soyisim: String) : Calisan(isim, soyisim)
{
    fun test()
    {

    }
}
var c1 : Calisan = Calisan("Ahmet", "BULUT")
c1.te
var s1 : Calisan = Stajyer("Mehmet", "YILDIZ")
s1.
