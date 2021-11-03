package com.reachplc.interview.api

import com.reachplc.interview.data.remote.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsService {

    @GET("android/products.json")
    suspend fun getProducts(): Response<ProductsResponse>
}
