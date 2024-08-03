package com.fermers_marketplace.fermers.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fermers_marketplace.fermers.R

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).placeholder(R.mipmap.ic_launcher).circleCrop().into(this)
}