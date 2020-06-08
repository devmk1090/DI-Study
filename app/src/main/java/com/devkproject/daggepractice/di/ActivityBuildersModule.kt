package com.devkproject.daggepractice.di

import com.devkproject.daggepractice.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): MainActivity
}