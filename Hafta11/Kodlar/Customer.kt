package com.example

import kotlinx.serialization.Serializable

//import kotlinx.serialization.Serializable
@Serializable
data class Customer(
    var id : String,
    var first_name : String,
    var last_name : String,
    var email : String
)