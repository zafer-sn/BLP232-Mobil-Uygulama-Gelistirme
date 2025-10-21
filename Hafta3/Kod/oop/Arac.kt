package com.example.kotlindersleri.oop

class A
{
    var isim1 = ""
    public var isim2 = "" // Varsayılan erisim belirteci publictir.
    private var isim3 = ""
    protected var isim4 = ""
    internal var isim5 = ""
    /*
    public -> Her yerden erişilebilir
    private -> Sadece ilgili scope içinden-class içinden
    protected -> Class içinden ve kalıtım verdiği class içinden
    internal -> İlgili modül içinden erişilebilir.
     */

}

class B
{
    fun test()
    {
        var ornek = A()
        // ornek.
    }
}




class Arac (var marka: String, var uretim_yili:Int, var otomatikmi : Boolean)
{
    fun calistir()
    {
        println("Arac calisiyor...")
    }

    fun bilgi_ver(renk: String)
    {
        println("Aracin markasi: ${this.marka}, rengi: ${renk}")
    }
}

fun main() {
    var honda = Arac("Honda", 2010, false)
    honda.calistir()
    honda.bilgi_ver("Beyaz")
    var opel = Arac("Opel", 2015, true)
    opel.calistir()
    opel.bilgi_ver("Kirmizi")
}