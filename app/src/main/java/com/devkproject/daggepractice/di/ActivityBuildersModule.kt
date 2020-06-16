package com.devkproject.daggepractice.di

import com.devkproject.daggepractice.di.auth.AuthModule
import com.devkproject.daggepractice.di.auth.AuthViewModelModule
import com.devkproject.daggepractice.ui.auth.AuthActivity
import com.devkproject.daggepractice.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelModule::class, AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity //subComponent

    //subComponent 확인 : java(generated) -> di -> ActivityBuildersModule_Contribute~ 확인
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity //subComponent
}