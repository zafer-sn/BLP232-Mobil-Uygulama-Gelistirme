package com.example

import kotlinx.serialization.Serializable

@Serializable
data class Ogrenci(
    val isim: String,
    val soyisim: String,
    val yas: Int
)
