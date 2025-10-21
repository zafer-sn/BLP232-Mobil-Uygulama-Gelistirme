package com.example.kotlindersleri.oop

fun main() {
    var sonuc = 5 carpim 3
    println(sonuc)
}

infix fun Int.carpim(sayi:Int) : Int
{
    return this * sayi
}