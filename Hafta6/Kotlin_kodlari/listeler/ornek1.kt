package com.example.hafta6bp.listeler

fun main() {
    var meyveler = listOf<String>("elma", "armut", "ayva")
    /* meyveler.add
    meyveler[0] = "cilek" */
    try {
        println(meyveler[3])
    }
    catch (e: ArrayIndexOutOfBoundsException)
    {
        println("Hata bulundu: ${e}")
    }
    catch (e: Exception)
    {
        println("Exception hatasi bulundu! ${e}")
    }
    finally {
        println("Finally calisti")
    }
}