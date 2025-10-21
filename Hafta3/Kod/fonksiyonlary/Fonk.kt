package com.example.kotlindersleri.fonksiyonlary
// fun -> function -> fonksiyon
fun main() {
    selamla()
    topla(3, 5)
    println(carp(5, 7))
    println(asalmi(-10))
    println(faktoriyel(5))
    println(us_bul(2, -2))
    // 2^-2 1/(2^2)
    println(fonksiyon(2, 3))
}

// GC -> Garbage Collector
// ARC
// Rust - Borrow Checker

fun fonksiyon(x:Int, y: Int) : Double
{
    return us_bul(x,2) + us_bul(y, 3) + 5
}

// f(x,y) = x^^2 + y ^^ 3 + 5
// f(2,3) = 4 + 27 + 5
// 36

fun us_bul(taban:Int, us:Int) : Double
{
    if(us == 0)
    {
        return 1.0
    } else if (us < 0)
    {
        return 1 / us_bul(taban, -us)
    }
    else
    {
        return taban * us_bul(taban, us-1)
    }    // 2 * us_bul(2,3)
}

fun faktoriyel(sayi:Int) : Int
{
        if(sayi == 0)
        {
            return 1
        }
        return sayi * faktoriyel(sayi-1)
}

fun asalmi(sayi: Int) : Boolean
{
    if (sayi < 2)
    {
        return false
    } else
    {
        var gelen_sayi_asalmi = true
        // 11 -> 2,3,...,10
        for (i in 2..sayi-1)
        {
            if(sayi % i == 0)
            {
                gelen_sayi_asalmi = false
                break
            }
        }
        return gelen_sayi_asalmi
    }
}

fun carp(sayi1: Int, sayi2: Int) : Int
{
    return sayi1 * sayi2
}

fun topla(sayi1:Int, sayi2:Int)
{
    println("Verilen sayilarin toplami: ${sayi1 + sayi2}")
}

fun selamla()
{
    println("Hosgeldiniz..")
}