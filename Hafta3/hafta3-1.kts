// region Veri Yapilari - 2
var dizi : Array<Int> = arrayOf<Int>(1,1,2,3,4)
var degisenListe = mutableListOf<Int>(11, 22, 33, 44)
var illerSet = mutableSetOf<String>("Bilecik", "Bilecik", "bilecik", "eskisehir", "eskisehir")
illerSet.add("Istanbul")
illerSet.forEach {
    println(it)
}
// println(illerSet[0]) -> Hata
var postMap = mutableMapOf<String, Any>(
    "isim" to "Zafer",
    "yas" to 30,
    "userId" to 1,
    "id" to 1,
    "title" to "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body" to "quia et suscipit nsuscipit recusandae consequuntur expedita et cumnreprehenderit molestiae ut ut quas totamnnostrum rerum est autem sunt rem eveniet architecto"
    )
// println(postMap["Zafer"]) -> null, istenmeyen çıktı
println(postMap.size)
println(postMap.keys)
println(postMap.values)
postMap.keys.forEach {
    println(it)
}
// endregion
// region Uygulama-1
println("Uygulama-1")
var ornekListe = mutableListOf<Any>()
for(i in 2500..5000)
{
    if(i % 2 == 0)
    {
        ornekListe.add(i)
    }
}
for(i in 0..ornekListe.size-1)
{
    if((ornekListe[i] as Int) % 5 == 0)
    {
        ornekListe[i] = "kullanici"
    }
}
ornekListe.forEach {
    println(it)
}

// endregion
// region Fonksiyon-Metot-Yordam
println("Fonksiyon-1")
fun selamla()
{
    println("Selam")
}
selamla()
selamla()
selamla()
selamla()
fun selamla2(isim: String, yas: Int)
{
    println("Hosgeldin ${isim}, yasin: ${yas}")
}
selamla2("Zafer", 30)
selamla2("Ahmet", 20)
fun hesapla(sayi1: Int, sayi2: Int) : Int
{
    return sayi1+sayi2
}
println(hesapla(11,22))
println(hesapla(24,35))
var sonuc: Int = 25 + hesapla(45,43)
println(sonuc)
// endregion
// region Ornek1
println("Faktoriyel")
fun Faktoriyel(sayi: Int) : Int
{
    if(sayi < 0)
    {
        throw Exception("Negatif faktoriyel olamaz!")
    }
    if(sayi == 0)
    {
        return 1;
    }
    return sayi * Faktoriyel(sayi-1) // Özyinelemeli fonksiyon
}
// 5 * 4 * 3 * 2 * 1 * 0 * -1 * -2 * -3, .....Faktoriyel(-2-1)
try {
    println(Faktoriyel(0))
} catch (e: Exception)
{
    println("Hata: ${e.message}")
}
// Bul(taban, us) Özyinelemeli fonksiyon kullanarak üs bulan fonksiyonu yazınız..
println("Üs bul")
fun Bul(taban: Int, us: Int) : Int
{
    if(us == 0)
    {
        return 1
    }
    return taban * Bul(taban, us-1)
}
println(Bul(5, 3))
// endregion
// region Ornek2
fun Asal(sayi: Int): Boolean
{
    var sayiAsalmi: Boolean = true
    for(i in 2..sayi-1)
    {
        if (sayi % i == 0)
        {
            sayiAsalmi = false
            break
        }
    }
    return sayiAsalmi
}
println(Asal(5))
println(Asal(9))
println(Asal(15))
println(Asal(29))
// endregion
// region OOP
println("OOP")
class Personel (var isim: String, var yas: Int, var brutMaas: Double, var kesintiler:Double)
{
    private var sicilNo: String = ""
    fun getSicilNo() : String
    {
        return this.sicilNo
    }
    fun setSicilNo(sicilNo: String)
    {
        this.sicilNo = sicilNo
    }
    public var cinsiyet1: Boolean = false
    private var cinsiyet2: Boolean = false
    internal var cinsiyet3: Boolean = false
    protected var cinsiyet4: Boolean = false
    // 4 tane erişim belirteci var
    // public, private, protected, internal
    init {
        println("Yapici metot tetiklendi!")
    }
    fun MaasHesapla() : Double
    {
        return brutMaas-kesintiler
    }
    /* var isim: String = ""
    var yas: Int = 0
    var brutMaas: Double = 0.0
    var kesintiler: Double = 0.0
    // Secondary constructor - İkincil constructor
    constructor(isim: String, yas: Int, brutMaas: Double, kesintiler: Double)
    {
        this.isim = isim
        this.yas = yas
        this.brutMaas = brutMaas
        this.kesintiler = kesintiler
        println("Yapici metot tetiklendi!")
    } */
}
// Personel p1 = new Personel();
// Yapıcı Metot - Constructor
var p1: Personel = Personel("Zemzem", 20, 250000.0, 100000.0)
var p2: Personel = Personel("Ömer", 21, 350000.0, 250000.0)
p1.isim
p1.setSicilNo("P1123")
println(p1.getSicilNo())
// p1.isim = "Zemzem"
// p1.yas = 20
// p1.brutMaas = 250_000.000
// p1.kesintiler = 100_000.000
println(p1.MaasHesapla())
println(p2.MaasHesapla())
// endregion