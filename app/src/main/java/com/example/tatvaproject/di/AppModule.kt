package com.example.tatvaproject.di

import android.app.Application
import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.tatvaproject.R
import com.example.tatvaproject.ui.activity.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesNavController(activity: MainActivity): NavController {
        return activity.findNavController(R.id.main_graph)
    }
}