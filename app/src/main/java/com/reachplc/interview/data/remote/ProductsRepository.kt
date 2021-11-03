package com.reachplc.interview.data.remote

import android.content.Context
import android.util.Log
import com.reachplc.interview.api.RetrofitClient
import retrofit2.HttpException
import java.io.IOException
import java.lang.IllegalStateException

class ProductsRepository(context: Context) {

    companion object {
        private var INSTANCE: ProductsRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = ProductsRepository(context)
            }
        }

        fun get(): ProductsRepository {
            return INSTANCE ?: throw IllegalStateException("Repository must be initialized")
        }
    }

    suspend fun getBeautyItems(): List<Product>? {
        val request = RetrofitClient.apiProductsService.getProductResponse()

        if (request.failed){
            Log.e("TAG", "getBeautyItems: Failed ${request.failed}")
            return null
        }

        if (!request.isSuccessful) {
            Log.e("TAG", "getBeautyItems: Data ${request.data}", )
            return null
        }


        return if (request.isSuccessful && request.body != null) {
            request.body?.products
        } else {
            Log.e("TAG", "getBeautyItems: Exception", request.exception)
            null
        }

    }
}