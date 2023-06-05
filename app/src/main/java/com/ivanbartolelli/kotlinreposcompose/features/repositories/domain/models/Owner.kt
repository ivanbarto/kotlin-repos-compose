package com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val userName: String?,
    val avatarUrl: String?,
    val profileUrl: String?
) : Parcelable

//fun OwnerEntity.toOwner(): Owner = Owner(userName, avatarUrl, profileUrl)