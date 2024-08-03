package com.fermers_marketplace.fermers.utils.ext

import android.content.Context
import android.widget.ImageView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley
import com.fermers_marketplace.fermers.R

fun ImageView.loadImage(url: String, context: Context) {
    val requestQueue: RequestQueue = Volley.newRequestQueue(context)

    val imageRequest = ImageRequest(
        url,
        { response ->
            this.setImageBitmap(response)
        },
        0, // Image width
        0, // Image height
        ImageView.ScaleType.CENTER_CROP,
        null,
        { error ->
            // Handle error
            this.setImageResource(R.mipmap.ic_launcher)
        }
    )

    requestQueue.add(imageRequest)
}