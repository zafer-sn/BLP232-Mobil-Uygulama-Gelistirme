package com.example.hafta6bp.listeler

fun main() {
    // unique - nadir, tekil
    var kumeler = setOf<Int>(11, 11, 11, 34, 1, 6, 34, 7, 9, 1)
    kumeler.forEach {
        println(it)
    }
}