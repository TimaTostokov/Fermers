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
        0,
        0,
        ImageView.ScaleType.CENTER_CROP,
        null,
        { _ ->
            this.setImageResource(R.mipmap.ic_launcher)
        }
    )

    requestQueue.add(imageRequest)

}