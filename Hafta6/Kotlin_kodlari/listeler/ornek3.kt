package com.example.hafta6bp.listeler

fun main() {
    var ondalikli = mutableListOf<Double>(3.14, 2.71, 1.88, 1.72)
    // 3 katindan 2 fazlasini bul
    ondalikli.forEach {
        //var sonuc = it * 3 + 2
        println(it*3+2)
    }
}