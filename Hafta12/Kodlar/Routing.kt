package com.example

import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

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

    }
}
