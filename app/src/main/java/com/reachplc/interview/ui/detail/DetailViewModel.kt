package com.reachplc.interview.ui.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.reachplc.interview.data.remote.Product
import com.reachplc.interview.utils.ProductPreferences

class DetailViewModel(application: Application) : AndroidViewModel(application) {


    fun isProductSaved(): Boolean {
        val prefs = ProductPreferences.getStoredPrefs(getApplication())
        return prefs.isNotBlank()
    }

    fun saveProduct(product: Product) {
        ProductPreferences.setStoredProduct(getApplication(), product.toString())
        Log.d("TAG", "saveProduct: $product")
    }

    fun deleteProduct() {
        ProductPreferences.deleteProduct(getApplication())
    }
}