package com.devkproject.daggepractice.di

import android.app.Application
import com.devkproject.daggepractice.BaseApplication
import com.devkproject.daggepractice.SessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class]
)

interface AppComponent: AndroidInjector<BaseApplication> {

    val sessionManager: SessionManager
        get() = SessionManager()

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}