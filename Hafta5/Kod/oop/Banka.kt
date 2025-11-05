package com.example.hafta5.oop

class Banka
{
    private var bakiye: Int = 0
    fun get_bakiye() : Int
    {
        return this.bakiye * 2
    }

    fun set_bakiye(deger: Int)
    {
        this.bakiye = deger * 5
    }
}

fun main() {
    var b1 = Banka()
    b1.set_bakiye(1000)
    println(b1.get_bakiye())
}