package com.reachplc.interview.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reachplc.interview.data.remote.Product
import com.reachplc.interview.data.remote.ProductsRepository
import com.reachplc.interview.data.remote.ProductsResponse
import kotlinx.coroutines.launch


class ListViewModel : ViewModel() {

    private val repository = ProductsRepository()

    private val _beautyProducts = MutableLiveData<List<Product>?>()
    val beautyProducts: LiveData<List<Product>?> = _beautyProducts

    fun getBeautyProducts() = viewModelScope.launch {

        val response = repository.getBeautyItems()
        _beautyProducts.postValue(response)
    }

}