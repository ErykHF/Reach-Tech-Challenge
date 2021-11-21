package com.reachplc.interview.ui.list

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.*
import com.google.android.material.snackbar.Snackbar
import com.reachplc.interview.data.remote.Product
import com.reachplc.interview.data.remote.ProductsRepository
import com.reachplc.interview.data.remote.ProductsResponse
import kotlinx.coroutines.launch


class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProductsRepository()

    private val _beautyProducts = MutableLiveData<List<Product>?>()
    val beautyProducts: LiveData<List<Product>?> = _beautyProducts

    fun getBeautyProducts() = viewModelScope.launch {

        val response = repository.getBeautyItems()
        _beautyProducts.postValue(response)
    }
}