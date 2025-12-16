package com.example
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
var customer_storage = mutableListOf<Customer>(
    Customer(
        "1",
        "Fatih",
        "TEST",
        "fatih@gmail.com"),
    Customer(
        "2",
        "Emirhan",
        "ORNEK",
        "emirhan@gmail.com"),
    Customer(
        "3",
        "Zeliha",
        "DENEME",
        "zeliha@gmail.com")
)
fun Application.configureRouting() {
    routing {
        get("/")
        {
            call.respondText("API calisiyor! /customer endpointine git.")
        }

        route("/customer")
        {
            get {
                call.respond(customer_storage)
            }
        }
    }
}
