package com.reachplc.interview.data.remote

import java.io.Serializable

data class Product(
    val id: String = "",
    var name: String = "",
    var image: String = "",
    var description: String = "",
    var price: Double = 0.0,
) : Serializable