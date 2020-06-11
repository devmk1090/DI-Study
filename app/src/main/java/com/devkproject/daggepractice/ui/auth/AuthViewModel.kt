package com.devkproject.daggepractice.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.devkproject.daggepractice.models.User
import com.devkproject.daggepractice.network.auth.AuthApi
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(authApi: AuthApi) : ViewModel() {
    companion object {
        const val TAG = "AuthViewModel"
    }
    init {
        Log.d(TAG, "AuthViewModel: viewmodel is working...")
        authApi.getUser(1)
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<User> {
                override fun onComplete() {}

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: User) {
                    Log.d(TAG, "onNext: ${t.email}")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError: $e")
                }
            })
    }
}