package com.zserin.sampleproject
import com.google.gson.Gson
import io.javalin.Javalin
import kotlin.contracts.contract

// Sadece veri tutulacaksa data class kullanılabilir
// Burada Kullanici classı ve constructorı tanımlandı
data class Kullanici(var isim:String, var yas:Int, var meslek:String)

fun main()
{
    // Web API için Javalin sunucusunun başlatılması
    // Varsayılan olarak 8080 portunda çalışır
    var app = Javalin.create().start()

    // Veritabanını simüle etmek için değiştirilebilir map(mutable map) tanımlıyoruz
    var kullaniciSozlugu = mutableMapOf(
        1 to Kullanici("Ahmet", 20, "ogrenci"),
        2 to Kullanici("Mehmet", 22, "doktor"),
        3 to Kullanici("Ayse", 18, "avukat"),
        4 to Kullanici("Nese", 25, "muhendis")
    )
    // 4'e kadar veri eklediğimiz için 5'ten devam etmek için bu değişkeni tanımlıyoruz
    var suankiId = 5

    // Gson classından bir nesne üretip gson ile referans veriyoruz
    // Böylece bu classtaki jsona çevirme gibi metotları kullanabileceğiz
    var gson = Gson()

    // localhost:8080/ urline get isteği atıldığında ekrana Merhaba, Javalin yazılır
    app.get("/")
    {
        ctx ->
        ctx.result("Merhaba, Javalin")
    }

    // /kullanici endpointine istek atıldığında json olarak kullaniciSozlugu yazilir
    app.get("/kullanici")
    {
        ctx ->
        ctx.json(kullaniciSozlugu)
    }

    // /kullanici/{id} endpointine istek atıldığında ilgili id değerini urlden alarak
    // kullaniciSozlugu'ndeki id değerine göre bulup getiren kod
    app.get("/kullanici/{id}")
    {
        ctx ->
        var bulunacakId = ctx.pathParam("id").toInt()
        var bulunacakKullanici = kullaniciSozlugu[bulunacakId]
        if (bulunacakKullanici != null)
        {
            ctx.json(bulunacakKullanici)
        } else
        {
            ctx.status(404).result("Kullanici bulunamadi")
        }
    }

    // /kullaniciEkle endpointine doğru formatta bir veri gönderilirse
    // gönderilen veriyi kullaniciSozlugu'ne ekleyen kod
    app.post("/kullaniciEkle")
    {
        ctx ->
        var eklenecekKullanici = gson.fromJson(ctx.body(), Kullanici::class.java)
        kullaniciSozlugu[suankiId] = eklenecekKullanici
        suankiId++
    }

    // /kullaniciSil/{id} endpointine atılan id'ye sahip kullanıcıyı silen kod
    app.delete("/kullaniciSil/{id}")
    {
        ctx ->
        var silinecekKullanici = ctx.pathParam("id").toInt()
        kullaniciSozlugu.remove(silinecekKullanici)
    }
}