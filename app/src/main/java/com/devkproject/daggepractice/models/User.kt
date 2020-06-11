package com.devkproject.daggepractice.models

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("website")
    val website: String

)