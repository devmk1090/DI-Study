package com.devkproject.daggepractice.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.devkproject.daggepractice.R
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
        }

        @JvmStatic
        @Provides
        fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }

        @JvmStatic
        @Provides
        fun provideDrawable(application: Application): Drawable? {
            return ContextCompat.getDrawable(application, R.drawable.logo)
        }

//        @JvmStatic
//        @Provides
//        fun someString(): String {
//            return "this is a test string"
//        }

//        @JvmStatic
//        @Provides
//        fun getApp(application: Application): Boolean {
//            return false
//        }

//        @JvmStatic
//        @Provides
//        fun someInt(string: String): Int {
//            return if(string == "this is a test string") 1 else 0
//        }
    }
}