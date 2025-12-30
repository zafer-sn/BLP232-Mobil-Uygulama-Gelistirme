package com.example

import io.ktor.http.HttpStatusCode
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.staticFiles
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.receive
import io.ktor.server.request.receiveMultipart
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.utils.io.jvm.javaio.toInputStream
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.util.UUID

fun Application.configureRouting()
{
    routing {
        get("/")
        {
            call.respondText("Merhaba, burasi anasayfadir...")
        }
        get("/hakkinda")
        {
            call.respondText("Merhaba, burasi hakkinda sayfasidir...")
        }
        get("/iletisim")
        {
            call.respondText("Merhaba, burasi iletişim sayfasidir...")
        }
        // path parametresi
        // query parametresi
        get("/selamver/{isim}")
        {
            val isim = call.pathParameters["isim"]
            call.respondText("Merhaba, ${isim}")
        }
        get("/selamla")
        {
            val isim = call.queryParameters["isim"] ?: "BOS"
            val soyisim = call.queryParameters["soyisim"] ?: "BOS"
            call.respondText("Merhaba ${isim} ${soyisim}, hoşgeldiniz...")
        }
        get("/ogrenciGoster")
        {
            val isim = call.queryParameters["isim"] ?: "DEGER YOK"
            val soyisim = call.queryParameters["soyisim"] ?: "DEGER YOK"
            val gelen_yas = call.queryParameters["yas"]
            val yas = gelen_yas?.toIntOrNull() ?: 0
            var o1 = Ogrenci("${isim}", "${soyisim}", yas)
            call.respond(o1)
        }
        post("/ogrenciKayit")
        {
            // Generic structure
            val o1 = call.receive<Ogrenci>()
            if(o1.yas < 18)
            {
                call.respond(
                    HttpStatusCode.BadRequest,
                    "Kayıt başarısız! Yaşınız küçük"
                )
            } else
            {
                call.respond(
                    HttpStatusCode.Created,
                    "Kayıt başarılı"
                )
            }
        }
        post("/oyunEkle")
        {
            var gelenAd = ""
            var gelenTur = ""
            var gelenResimDosya : String? = null
            var multipart = call.receiveMultipart()
            multipart.forEachPart {
                when(it)
                {
                    // Object - Any
                    // object t = 3;
                    // cw((int)t * 2)
                    is PartData.FormItem -> {
                        // "isim": "Zafer"
                        // key-value
                        if(it.name == "ad")
                        {
                            gelenAd = it.value
                        } else if (it.name == "tur")
                        {
                            gelenTur = it.value
                        }
                    }
                    is PartData.FileItem -> {
                        // deneme.jpg
                        var originalFileName = it.originalFileName ?: "dosya.jpg"
                        var uzanti = File(originalFileName).extension
                        // UUID - Unique
                        // nwkjagnksng_*1234.png - nwkjagnksng_*1234.jpg, jpeg
                        var yeniDosyaAdi = "${UUID.randomUUID()}.${uzanti}"
                        var dosya = File("images", yeniDosyaAdi)
                        it.provider().toInputStream().use { input ->
                            dosya.outputStream().buffered().use {
                                input.copyTo(it)
                            }
                        }
                        gelenResimDosya = yeniDosyaAdi
                    }
                    else -> {}
                }
                it.dispose()
            }
            if(gelenAd.isNotEmpty() && gelenTur.isNotEmpty())
            {
                try {
                    transaction {
                        Oyunlar.insert {
                            it[ad] = gelenAd
                            it[tur] = gelenTur
                            it[resimDosya] = gelenResimDosya
                        }
                    }
                    call.respond(HttpStatusCode.Created, "Kayit basarili!")
                } catch (e: Exception)
                {
                    call.respond(HttpStatusCode.InternalServerError, "Sunucu hatasi!")
                }
            }
            else
            {
                call.respond(HttpStatusCode.BadRequest, "Eksik veri!")
            }
        }
        get("/oyunGetir")
        {
            try {
                var oyunListesi = transaction {
                    // Raw - ham - çiğ
                    Oyunlar.selectAll().map {
                        Oyun(
                            it[Oyunlar.id],
                            it[Oyunlar.ad],
                            it[Oyunlar.tur],
                            it[Oyunlar.resimDosya]
                        )
                    }
                }
                call.respond(oyunListesi)
            }catch (e: Exception)
            {
                call.respond(HttpStatusCode.InternalServerError, "Sunucu hatasi!")
            }

        }



        staticFiles("/resimler", File("images"))
    }
}
