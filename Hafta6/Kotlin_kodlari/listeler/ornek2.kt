package com.example.hafta6bp.listeler

fun main() {
    var plakalar = mutableListOf<Int>(11, 34, 35, 6, 1)
    plakalar.add(2, 49)
    plakalar.remove(6)
    plakalar.removeAt(0)
    // plakalar.reverse()
    var plakalar2 = plakalar.reversed()
    plakalar2.forEach { eleman ->
        // iteration - iterasyon
        println(eleman)
    }
}