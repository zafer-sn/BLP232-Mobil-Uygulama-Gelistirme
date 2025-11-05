package com.example.hafta5.oop

open class Arac
{
    private var teker_sayisi: Int = 0
    protected var km: Double = 0.0
    fun hareket()
    {
        println("Arac hareket ediyor...")
    }
}

class BMW : Arac()
{

}

fun main() {
    var a1 : Arac = Arac()
    a1.hareket()

    var b1 = BMW()
    b1.hareket()
}