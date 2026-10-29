// region Kalıtım ve Statik Yapilar
// Kotlin programlama dilinde
// classlar varsayılan olarak final keywordü ile işaretlidir.
open class Personel
{
    var ad = ""
    var soyad = ""
    var yas = 0
    var kilo = 0.0
    var boy = 0.0
    fun Maas(){}
}
class AkademikPersonel : Personel()
{
    var dersler = mutableListOf<String>()
}
class IdariPersonel : Personel()
{
    fun OgrenciBelgesi()
    {

    }
}






interface IAPI
{
    var requestCount: Int
    fun get() // Signature
}
interface IPut
{
    var body: String
}

open class Patch
{

}

class Post : Patch(), IAPI, IPut
{
    override var requestCount: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun get() {

    }

    override var body: String
        get() = TODO("Not yet implemented")
        set(value) {}

}

var post1: IAPI = Post()






open class Product (var price: Double)
{
    //var price: Double = 0.0
    open fun taxCalculate() : Double
    {
        return this.price * 0.18
    }
}
class Electronic (price: Double) : Product(price)
{
    override fun taxCalculate(): Double {
        return this.price * 0.2
    }
}
var product1 : Product = Product(20000.0)
println(product1.taxCalculate())
var electronic1: Electronic = Electronic(20000.0)
println(electronic1.taxCalculate())
println("-------------------------------------------------")

open class Calisan (var yas: Int)
{
    init { }
    private var isim: String = ""
    protected var soyisim: String = ""
    fun EmeklilikHesapla(yas: (dogumYili: Int) -> Int, primGunSayisi: Int, sigortalilikSuresi: Int, sigortaKolu: String)
    {

    }
}
class Stajyer (yas: Int) : Calisan(yas)
{
    var calismaGunu: Int = 0
    fun Yazilim()
    {
        // super.EmeklilikHesapla()
    }
}
fun Yas()
{

}
fun topla(sayi: Int = 10, sayi2: Int=25, fonksiyon1: () -> Unit)
{

}
topla {

}

var s1: Calisan = Stajyer(40)
var c1 : Calisan = Calisan(45)
c1.EmeklilikHesapla({dogumYili ->
    var ornek: Int = 20
    dogumYili
                    }, 30, 30, "Bagkur")

class Okul
{
    var isim: String = "" // public(varsayılan), private, protected, internal
    var kurulusYili: Int = 1994
    companion object{
        var bolumSayisi:Int = 0
        fun OkulAcilisi()
        {

        }
    }
}
// Singleton tasarım deseni
var o1: Okul = Okul()
Okul.bolumSayisi = 8
Okul.OkulAcilisi()
var o2: Okul = Okul()
var o3: Okul = Okul()
// endregion
