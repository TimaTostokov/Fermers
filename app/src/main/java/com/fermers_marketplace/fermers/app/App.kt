package com.fermers_marketplace.fermers.app

import android.app.Application
import com.fermers_marketplace.fermers.utils.pref.ProfileSharedPreferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){

    var mySharedPreferences: ProfileSharedPreferences? = null

    override fun onCreate() {
        super.onCreate()

        mySharedPreferences = ProfileSharedPreferences(this)
    }
}