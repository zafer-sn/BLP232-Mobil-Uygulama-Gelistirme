package com.zserin.sampleproject

// class(sınıf) tanımlama - başla
/* Aşağıdaki (var hucreSayisi:Int, var hucreTuru:String) kısım
yapıcı metot(constructor) olarak kullanılır.*/
class Canli(var hucreSayisi:Int, var hucreTuru:String)
{
    /*
    * Kotlin ile 4 adet erişim belirteci kullanılır
    * public: Her yerden erişilebilir(varsayılan budur)
    * private: Sadece class içinden(class süslü parantezlerinden) erişilir
    * protected: Sadece class içinden ve kalıtım verdiği(varsa) class içinden erişilir
    * internal: Sadece ilgili proje içinden erişilir
    * */
    public var dolasim = true
    private var yasamSuresi = 0.0
    protected var metabolizmaTuru = ""
    internal var ceperSayisi = 0
}
// class(sınıf) tanımlama - bitir

// Kalıtım(Inheritance) - başla
/*
* Kotlinde bir class open veya final ile işaretlenebilir.
* Varsayılan olarak final ile işaretlidir. final ile işaretli bir class
* kalıtım veremez!(kalıtım alabilir) Kalıtım vermesine izin vermek için open ile işaretlenmelidir.
* */
open class Arac
{

}

class Araba : Arac()
{

}
// Kalıtım(Inheritance) - bitir

// Polymorphism(Çok biçimlilik) - başla
/*
* Kotlin'de bir metot veya özelliğin ezilmesi için open ile işaretlenerek
* alt classta override ile ezilmesi gerekir
* */
open class Hayvan
{
    open fun ses()
    {
        println("Hayvan ses çıkarıyor")
    }
}
class Kedi : Hayvan()
{
    override fun ses() {
        println("Kedi ses çıkarıyor")
    }
}
// Polymorphism(Çok biçimlilik) - bitir

// Kapsülleme(encapsulayion) - başla
class Banka
{
    private var bakiye = 0.0
    fun getBakiye() : Double
    {
        return bakiye // return this.bakiye'de yazılabilir
    }
    fun setBakiye(value:Double)
    {
        bakiye = value // this.bakiye = value'da yazılabilir
    }
    // 2. yöntem ile kapsülleme
    private var _deger:Double = 0.0
    public var deger:Double
        get() {return _deger}
        set(value) {_deger = value}

}
// Kapsülleme(encapsulayion) - bitir

// Soyutlama(Abstraction) - başla
abstract class Ev
{
    abstract var pencereSayisi:Int
    abstract fun zil()
}

class BenimEvim : Ev()
{
    override var pencereSayisi: Int = 4

    override fun zil() {
        println("Evimin zili çalıyor")
    }
}
// Soyutlama(Abstraction) - bitir
fun main()
{
    // Arrow - Lambda Function - başla
    var topla = {sayi1:Int, sayi2:Int -> sayi1 + sayi2}
    println(topla(14, 23)) // ekrana 37 yazar
    // Arrow - Lambda Function - bitir

    //Nesne üretip referans ile işaretleme - başla
    var c1 = Canli(25,"Bitki")
    //Nesne üretip referans ile işaretleme - bitir

    // Nesne üzerinden polymorphism gösterimi - başla
    var h1 = Hayvan()
    h1.ses() // Ekrana hayvan ses çıkarıyor yazar
    var k1 = Kedi()
    k1.ses() // Ekrana kedi ses çıkarıyor yazar
    // Nesne üzerinden polymorphism gösterimi - bitir

    // Nesne üzerinden kapsülleme gösterimi - başla
    var banka1 = Banka()
    banka1.setBakiye(100.0)
    banka1.getBakiye()

    banka1.deger = 250.0
    println(banka1.deger)
    // Nesne üzerinden kapsülleme gösterimi - bitir

    // Nesne üzerinden soyutlama gösterimi - başla
    var benimevim1 = BenimEvim()
    println(benimevim1.pencereSayisi)
    benimevim1.zil()
    // Nesne üzerinden soyutlama gösterimi - bitir
}