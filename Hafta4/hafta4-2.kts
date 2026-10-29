// final - Kalıtım veremez!
// open - Kalıtım verebilir
open class Product
{
    private var id: Int = 0
    fun price2()
    {
        id=11
    }
}
class Electronic : Product()
{
    fun price()
    {

    }
}
var p1:Product = Product()
var e1:Electronic = Electronic()





// Primary (Birincil) yapıcı metot
class Employee
{
    var bankAccount: String = ""
    private var workingHour: Int = 0 // public
    fun getWorkingHour() : Int
    {
        return this.workingHour
    }
    fun setWorkingHour(hour: Int)
    {
        this.workingHour = hour*2
    }
}
//var e1:Employee = Employee()
//e1.setWorkingHour(8)
//println(e1.getWorkingHour())
println("------------------------------------------")



class Personel (var isim: String, var yas: Int, kilo: Double)
{
    lateinit var TC: String
    // var isim: String = ""
    // init- initalize - başlatmak
    init {
        println("Personel yapici metodu çalıştı")
        this.TC = "1234"
    }
    // public, private, protected, internal
    /*var isim: String = "" // Kotlin toplam 4 tane erişim belirteci var
    public var yas: Int = 0
    var brutMaas: Double = 0.0
    var kesintiler: Double = 0.0
    fun MaasHesapla(brutMaas: Double, kesintiler: Double) : Double
    {
        this.brutMaas = brutMaas
        this.kesintiler = kesintiler
        return brutMaas-kesintiler
    }
    // Yapıcı-Kurucu metot
    // Secondary(İkincil yapıcı metot)
    constructor(isim: String, yas: Int)
    {
        println("Personel yapici metodu çalıştı")
        this.isim = isim
        this.yas = yas
    }*/
}

var omer:Personel = Personel("Ömer", 20, 75.6)
omer.isim = "Ahmet"
//println(omer.MaasHesapla(50000.0, 15000.0))
var kubra: Personel = Personel("Kübra", 21, 74.2)
//println(kubra.MaasHesapla(50000.0, 12000.0))
//Personel p1 = new Personel();