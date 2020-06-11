package com.devkproject.daggepractice.di

import com.devkproject.daggepractice.di.auth.AuthModule
import com.devkproject.daggepractice.di.auth.AuthViewModelModule
import com.devkproject.daggepractice.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelModule::class, AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity
}