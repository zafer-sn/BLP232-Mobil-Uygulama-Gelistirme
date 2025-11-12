package com.example.hafta6bp.listeler

import java.io.File

fun main() {
    var dosya = File("ornek.txt")
    dosya.writeText("Bu dosyam benim tarafimdan olustuldu!\n")
    dosya.appendText("Yeni bir ekleme yaptim..")
}
/*
iç içe for
içerideki for dıştaki forun sayısına kadar gitmeli
 */