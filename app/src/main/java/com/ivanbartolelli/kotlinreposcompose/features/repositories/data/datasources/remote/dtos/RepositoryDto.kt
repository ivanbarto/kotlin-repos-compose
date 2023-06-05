package com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.dtos

import com.google.gson.annotations.SerializedName
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.dtos.OwnerDto

data class RepositoryDto(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("full_name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("ssh_url")
    val sshUrl: String?,
    @SerializedName("git_url")
    val gitUrl: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("watchers_count")
    val watchersCount: Long?,
    @SerializedName("owner")
    val owner: OwnerDto?,
    var timestamp : Long
)
