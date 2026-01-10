package com.example

import kotlinx.serialization.Serializable

@Serializable
data class Oyun(
    val id: Int,
    val ad: String,
    val tur: String,
    val resimDosya: String?
)