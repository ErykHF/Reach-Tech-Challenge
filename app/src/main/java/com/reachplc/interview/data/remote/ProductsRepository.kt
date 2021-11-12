package com.reachplc.interview.data.remote

import android.util.Log
import com.reachplc.interview.api.RetrofitClient


class ProductsRepository {


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