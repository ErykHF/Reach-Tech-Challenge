package com.reachplc.interview.utils

import android.content.Context
import android.preference.PreferenceManager

private const val PREF_PRODUCT = "productPref"



object ProductPreferences {

    fun getStoredPrefs(context: Context): String {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(PREF_PRODUCT, "")!!
    }

    fun setStoredProduct(context: Context,query: String){
        PreferenceManager.getDefaultSharedPreferences(context)
            .edit().putString(PREF_PRODUCT, query)
            .apply()
    }

    fun deleteProduct(context: Context){
        PreferenceManager.getDefaultSharedPreferences(context).edit().clear().apply()
    }

}