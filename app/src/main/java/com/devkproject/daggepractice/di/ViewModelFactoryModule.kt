package com.devkproject.daggepractice.di

import androidx.lifecycle.ViewModelProvider
import com.devkproject.daggepractice.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}