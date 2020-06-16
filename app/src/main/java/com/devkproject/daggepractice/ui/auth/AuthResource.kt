package com.devkproject.daggepractice.ui.auth

sealed class AuthResource<T>(
    var status: AuthStatus,
    var data: T? = null,
    var message: String? = null
) {
    class Authenticated<T>(data: T) :
        AuthResource<T>(AuthStatus.AUTHENTICATED, data, null)

    class Error<T>(message: String, data: T? = null) :
        AuthResource<T>(AuthStatus.ERROR, data, message)

    class Loading<T>(data: T? = null) :
        AuthResource<T>(AuthStatus.LOADING, data, null)

    class Logout<T>() :
        AuthResource<T>(AuthStatus.NOT_AUTHENTICATED, null, null)

    enum class AuthStatus {
        AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED
    }
}