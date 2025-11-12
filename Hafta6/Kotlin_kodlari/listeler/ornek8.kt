package com.example.hafta6bp.listeler

fun main() {
    var bilgi = mutableMapOf<String, Any>(
        "isim" to "Zafer",
        "yas" to 30,
        "boy" to 1.75)

    bilgi["kilo"] = 90.0
    bilgi.values.forEach {
        println(it)
    }
    println(bilgi["yas"] as Int * 2)
}