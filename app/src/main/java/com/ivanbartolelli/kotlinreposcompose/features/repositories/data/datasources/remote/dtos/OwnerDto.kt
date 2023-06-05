package com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.dtos

import com.google.gson.annotations.SerializedName

data class OwnerDto(
    @SerializedName("login")
    val userName : String?,
    @SerializedName("avatar_url")
    val avatarUrl : String?,
    @SerializedName("url")
    val profileUrl : String?
)