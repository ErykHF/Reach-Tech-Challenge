package com.reachplc.interview.data.remote

import java.io.Serializable

data class Product(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val description: String = "",
    val price: Double = 0.0,
) : Serializable