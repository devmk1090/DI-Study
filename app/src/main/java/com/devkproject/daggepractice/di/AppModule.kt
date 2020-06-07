package com.devkproject.daggepractice.di

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun someString(): String {
            return "this is a test string"
        }

        @JvmStatic
        @Provides
        fun getApp(application: Application): Boolean {
            return false
        }

//        @JvmStatic
//        @Provides
//        fun someInt(string: String): Int {
//            return if(string == "this is a test string") 1 else 0
//        }
    }
}