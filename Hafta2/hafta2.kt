package com.zserin.hft2

fun main()
{
    /* Ornek-1
    print("Lütfen vize notunu giriniz..:")
    var vizeNotu = readLine()!!.toInt()
    print("Lütfen final notunu giriniz..:")
    var finalNotu = readLine()!!.toInt()
    var ortalama = (vizeNotu * 0.4) + (finalNotu * 0.6)
    print("Sizin not ortalamanız: ${ortalama}")
    if(ortalama < 50)
    {
        print("Harf notunuz FF")
    } else if (ortalama >= 51 && ortalama <= 60)
    {
        print("Harf notunuz DD")
    } else
    {
        print("Harf notunuz AA")
    }*/

    /* Ornek - 2
    for (i in 100 downTo 5 step 5)
    {
        println(i)
    } */

    /* Ornek - 3
    var i = 0
    while (i < 10)
    {
        println(i)
        i++
    }

    while (true)
    {
        break
    }*/

    /* Ornek - 4
    var liste = arrayListOf(5, false, 10, "merhaba", 3.14)
    liste.forEach {println(it)}*/

    /*var a = selamla()
    var b = deger()
    println(b * 2)*/

    /* Ornek - 5
    var c = topla(2, 3)
    println(c) */
    /* Ornek - 6
    for(i in 2..150)
    {
        println("Sayı: ${i}, Asalmı = ${asalKontrol(i)}")
    }*/


}
/* Fonkisyonlar
fun selamla()
{
    print("10")
}

fun deger() : Int
{
    return 10
}

fun topla(sayi1: Int, sayi2: Int) : Int
{
    return sayi1 + sayi2
}

fun asalKontrol(sayi : Int) : Boolean
{
    var asal = true
    for (i in 2..sayi-1)
    {
        if (sayi % i == 0)
        {
            asal = false
            break
        }
    }
    return asal
}*/
