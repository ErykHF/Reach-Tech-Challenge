package com.reachplc.interview.api


import com.reachplc.interview.data.remote.ProductsResponse
import retrofit2.Response
import java.lang.Exception

class ApiClient(private val productApi: ProductsService) {


    suspend fun getProductResponse(): SimpleResponse<ProductsResponse> {
        return safeApiCall { productApi.getProducts() }
    }


    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }

}