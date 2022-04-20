package com.example.tatvaproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplications: Application(){

    override fun onCreate() {
        super.onCreate()
    }
}

