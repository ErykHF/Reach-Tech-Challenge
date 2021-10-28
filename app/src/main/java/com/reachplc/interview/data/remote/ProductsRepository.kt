package com.reachplc.interview.data.remote

import android.content.Context
import android.util.Log
import com.reachplc.interview.di.AppContainer
import java.lang.IllegalStateException

class ProductsRepository(context: Context) {

    companion object{
        private var INSTANCE: ProductsRepository? = null

        fun initialize (context: Context){
            if (INSTANCE == null){
                INSTANCE = ProductsRepository(context)
            }
        }

        fun get(): ProductsRepository {
            return INSTANCE ?:
            throw IllegalStateException("Repository must be initialized")
        }
    }

    suspend fun getBeautyItems(): List<Product>? {
        val request = AppContainer().retrofit.getProducts()

        if (!request.isSuccessful){
            Log.d("TAG", "Repository Get Beauty Items: ${request.code()}")
        }

        return request.body()?.products
    }
}