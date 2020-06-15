package com.devkproject.daggepractice.models

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    var id: Int,
    @SerializedName("username")
    val username: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("website")
    val website: String?

)