package com.reachplc.interview.data.remote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class ProductsResponse(val products : MutableList<Product>)
