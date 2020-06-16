package com.devkproject.daggepractice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.devkproject.daggepractice.models.User
import com.devkproject.daggepractice.ui.auth.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    companion object {
        const val TAG = "SessionManager"
    }

    private val cachedUser: MediatorLiveData<AuthResource<out User>> = MediatorLiveData()

    fun authenticatedWithId(source: LiveData<AuthResource<out User>>) {
        if(cachedUser != null) {
            cachedUser.value = AuthResource.Loading(null)
            cachedUser.addSource(source, Observer {
                cachedUser.value = it
                cachedUser.removeSource(source)
            })
        }
    }

    fun getAuthUser(): LiveData<AuthResource<out User>> {
        return cachedUser
    }

    fun logOut() {
        Log.d(TAG, "logOut: logging out.........")
    }
}