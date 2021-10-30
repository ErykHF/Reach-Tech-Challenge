package com.reachplc.interview.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Patterns
import android.widget.EditText
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition


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
