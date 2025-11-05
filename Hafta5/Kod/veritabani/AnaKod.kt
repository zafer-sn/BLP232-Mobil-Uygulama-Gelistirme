package com.example.hafta5.veritabani

fun main() {
    var k1 = Kategoriler(1, "Dram")
    var k2 = Kategoriler(2, "Komedi")
    var k3 = Kategoriler(3, "Bilim Kurgu")

    var y1 = Yonetmenler(1,"Nuri Bilge CEYLAN")
    var y2 = Yonetmenler(2,"Quentin TARANTINO")
    var y3 = Yonetmenler(3,"Christopher NOLAN")

    var f1 = Filmler(1,
        "Django",
        2013,
        k1,
        y2)

    var f2 = Filmler(2,
        "Inception",
        2006,
        k3,
        y3)

    println("--------------------------------")
    println(f1.film_id)
    println(f1.film_ad)
    println(f1.film_yil)
    println(f1.kategori_id.kategori_adi)
    println(f1.yonetmen_id.yonetmen_adi)
    println("--------------------------------")
}