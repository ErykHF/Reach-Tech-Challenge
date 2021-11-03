package com.reachplc.interview.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private val retrofit: ProductsService by lazy {
        Retrofit.Builder()
            .baseUrl("https://apps-tests.s3-eu-west-1.amazonaws.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ProductsService::class.java)
    }

    val apiProductsService = ApiClient(retrofit)
}