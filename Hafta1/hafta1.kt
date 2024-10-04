fun main()
{
    // Tek Satırlı Yorum Satırı
    /*
    * Çok Satırlı
    * Yorum Satırı
    * */

    // Konsola Yazdırma
    println("Merhaba Dünya!")

    // Değişken Tanımlama
    /* var ile tanımlanan değişkenlerin
    * değeri sonradan değiştirilebilir
    * */
    var tamsayi = 11
    tamsayi = 50
    var ondalikliSayi = 11.22
    var mantiksal = true
    var metinsel = "Merhaba"
    /* val ile tanımlanan değişkenlerin
    * değeri sonradan değiştirilemez!
    * */
    val tamsayi2 = 25
    // Hata - tamsayi2 = 50
    // Değişken Tipi Belirleme(İstenirse)
    var tamsayi3:Int = 30
    var ondalikSayi2:Double = 40.2
    var mantiksal2:Boolean = false
    var metinsel2:String = "selam"

    // Tür Dönüşümü
    var metinselSayi = "25"
    var integerSayi = metinselSayi.toInt()
    var metinselBool = "faLse"
    var boolDeger = metinselBool.toBoolean()

    /*Dizi tanımlama dizi elemanlarına [] ile
    * erişilebilir. Diziye sonradan eleman eklenemez!
    * İndisleme 0'dan başlar*/
    var dizi = arrayOf("ornek", 11, 11.22, false)
    println(dizi[0]) // "ornek"

    /*Liste tanımlama liste elemanlarına [] ile
    * erişilebilir. Listeye sonradan eleman eklenebilir
    * İndisleme 0'dan başlar*/
    var liste = arrayListOf("deneme", 33, true, 3.14)
    liste.add(55) // Liste sonuna eleman ekler
    liste.remove("deneme") // İlgili elemanı listeden siler

    /*Set(Kume) tanımlama, kume elemanlarına [] ile erişilemez!
     Kumelerde her bir eleman sadece 1 kez bulundurulur*/
    var kume = setOf(0, 0, 1,1,1,"selam", 4)

    /*Map(Sozluk) tanımlama, sozluk elemanları key-value(anahtar-değer)
     * ikilileri olarak ifade edilir. İlgili anahtara karşılık gelen değer
     * yazdırılır*/
    var sozluk = mapOf("okul" to "BSEU", "yil" to 1994, "lab" to true)
    println(sozluk["okul"]) // okul anahtarı karşılık gelen değer(BSEU) yazdırılır.


}