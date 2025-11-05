package com.example.hafta5.oop

open class Bitki
{
    open fun fotosentez()
    {
        println("Bitki fotosentez yapiyor...")
    }
}

class Papatya : Bitki()
{
    override fun fotosentez()
    {
        println("Papatya fotosentez yapiyor...")
    }
}

fun main() {
    var b1 = Bitki()
    var p1 = Papatya()
    b1.fotosentez()
    p1.fotosentez()
}