package com.devkproject.daggepractice.di.auth

import androidx.lifecycle.ViewModel
import com.devkproject.daggepractice.di.ViewModelKey
import com.devkproject.daggepractice.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}