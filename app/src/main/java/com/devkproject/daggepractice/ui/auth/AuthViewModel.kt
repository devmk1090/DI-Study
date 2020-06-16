package com.devkproject.daggepractice.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.devkproject.daggepractice.SessionManager
import com.devkproject.daggepractice.models.User
import com.devkproject.daggepractice.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthViewModel @Inject constructor(
    private val authApi: AuthApi,
    private var sessionManager: SessionManager
) : ViewModel() {

    companion object {
        const val TAG = "AuthViewModel"
    }

    fun authenticatedUser(userId: Int) {
        Log.d(TAG, "Attempting to authenticated the user......")
        sessionManager.authenticatedWithId(queryUserId(userId))
    }

    private fun queryUserId(userId: Int): LiveData<AuthResource<out User>> {
        return LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId).onErrorReturn{
                Log.d(TAG, "user auth error seems to be ${it.message}")
                return@onErrorReturn User(-1, null, null, null)
            }.map {
                if (it.id == -1) {
                return@map AuthResource.Error("Could not authenticate", null)
            } else {
                return@map  AuthResource.Authenticated(it)
            }
            }.subscribeOn(Schedulers.io())
        )
    }

    fun observeAuthState(): LiveData<AuthResource<out User>> {
        return sessionManager.getAuthUser()
    }
}