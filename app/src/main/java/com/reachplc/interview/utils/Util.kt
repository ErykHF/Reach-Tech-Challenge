package com.reachplc.interview.utils

import android.content.Context
import android.util.Patterns
import android.widget.EditText
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide


object Util {

    fun getProgressDrawable(context: Context): CircularProgressDrawable {
        return CircularProgressDrawable(context).apply {
            strokeWidth = 10f
            centerRadius = 50f
            start()
        }
    }

    fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
        Glide.with(this).load(uri).placeholder(progressDrawable).into(this)
    }

}
