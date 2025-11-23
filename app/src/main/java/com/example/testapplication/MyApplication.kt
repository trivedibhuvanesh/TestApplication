package com.example.testapplication

import android.app.Application
import com.example.testapplication.utils.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Prefs.init(this)
    }
}