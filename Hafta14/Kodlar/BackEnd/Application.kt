package com.example

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/game",
        driver = "org.postgresql.Driver",
        user = "",
        password = ""
    )
    transaction {
        SchemaUtils.create(Oyunlar, Yapimcilar, OyunYapimci)
    }
    configureSerialization()
    configureRouting()
}
