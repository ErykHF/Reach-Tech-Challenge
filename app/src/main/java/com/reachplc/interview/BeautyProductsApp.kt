package com.reachplc.interview

import android.app.Application
import com.reachplc.interview.data.remote.ProductsRepository
import com.reachplc.interview.di.AppContainer

class BeautyProductsApp : Application() {

    // Instance of AppContainer that will be used by all the Activities of the app
    val appContainer = AppContainer()

    override fun onCreate() {
        super.onCreate()

    }
}
