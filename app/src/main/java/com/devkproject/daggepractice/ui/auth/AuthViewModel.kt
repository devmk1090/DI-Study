package com.devkproject.daggepractice.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.devkproject.daggepractice.models.User
import com.devkproject.daggepractice.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    private val TAG: String = "AuthViewModel"
    private var authUser: MediatorLiveData<AuthResource<out User>> = MediatorLiveData()

    fun authenticateUser(userID: Int) {
        authUser.value = AuthResource.Loading(null)

        val source: LiveData<AuthResource<out User>> = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userID).onErrorReturn {
                return@onErrorReturn User(-1, null, null, null)
            }.map {
                if (it.id == -1) {
                    return@map AuthResource.Error("Could not authenticate", null)
                } else {
                    return@map AuthResource.Authenticated(it)
                }
            }.subscribeOn(Schedulers.io())
        )

        authUser.addSource(source) {
            authUser.value = it
            authUser.removeSource(source)
        }
    }

    fun observeUser(): LiveData<AuthResource<out User>> {
        return authUser
    }
}