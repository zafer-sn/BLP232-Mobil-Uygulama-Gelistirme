package com.example

import kotlinx.serialization.Serializable

@Serializable
data class Oyun(
    var id: Int,
    var ad: String,
    var tur: String,
    var resimDosya : String?
)