package com.example.hafta6bp.listeler

fun main() {
    var plakalar = mutableSetOf<Int>(11, 11, 22, 34, 55, 6, 8)
    plakalar.add(55)
    plakalar.remove(11)
    plakalar.forEach {
        println(it)
    }
}