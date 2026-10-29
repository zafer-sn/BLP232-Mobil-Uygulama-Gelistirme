class Personel (var isim: String, soyisim: String)
{
    constructor(yas: Int) : this("Zafer", "Serin")
    {
        println("Secondary Constructor")
    }
    companion object
    {
        var maas: Double = 20.000
    }
}



var p1: Personel = Personel(30)
Personel.maas

fun fonksiyon1(benimFonksiyon: (sayi11: Int, sayi12:Int) -> Unit, sayi1: Int, sayi2: Int)
{
    println("Fonksiyon1 çalıştı")
    benimFonksiyon(30,40)

}
println("--------------------------")
fonksiyon1({ deger11, deger22 ->
    println("Selam")
    println(deger11)
    println(deger22)
},30, 50)
println("--------------------------")

fun fonksiyon2()
{
    println("Fonksiyon2 çalıştı")
}






fun selamla(fonksiyon2: () -> Int, sayi1: Int, sayi2: Int, fonksiyon1: () -> Unit)
{
    println("Selamla baslangic")
    fonksiyon1()
    fonksiyon2()
}

fun ornek1() : Int
{
    println("ornek1")
    return  5
}
fun ornek2(): Unit
{
    println("ornek2")
}
selamla(::ornek1, 15, 30, ::ornek2)


println("************************************")
fun Asal(sayi: Int): Boolean
{
    var gelenSayiAsalmi: Boolean = true
    for (i in 2..sayi-1)
    {
        if (sayi % i == 0)
        {
            gelenSayiAsalmi = false
            break
        }
    }
    return gelenSayiAsalmi
}
fun AsalFaktoriyel(sayi: Int = 5, Asal: (sayi:Int)-> Boolean) : Int
{
    var faktoriyel: Int = 1
    if (Asal(sayi) == true)
    {
        for (i in 2..sayi)
        {
            faktoriyel = faktoriyel * i
        }
    }
    return faktoriyel
}
AsalFaktoriyel{
    var gelenDegerAsalmi = true
    for (i in 2..it-1)
    {
        if(it % i == 0)
        {
            gelenDegerAsalmi = false
            break
        }
    }
    gelenDegerAsalmi
}


