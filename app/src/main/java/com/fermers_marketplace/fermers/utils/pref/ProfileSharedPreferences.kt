package com.fermers_marketplace.fermers.utils.pref

import android.content.Context
import android.content.SharedPreferences

class ProfileSharedPreferences(
    val context: Context
) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "TODO APP SETTINGS", Context.MODE_PRIVATE
    )

    fun saveName(name: String){
        sharedPreferences.edit()
            .putString("USER_NAME", name)
            .apply()
    }

    fun getName(): String?{
        return sharedPreferences.getString("USER_NAME", "User Name")
    }

    fun  saveImage(img: String){
        sharedPreferences.edit().putString("USER_AVATAR", img).apply()
    }

    fun getImage(): String?{
        return sharedPreferences.getString("USER_AVATAR", "USER")
    }

}