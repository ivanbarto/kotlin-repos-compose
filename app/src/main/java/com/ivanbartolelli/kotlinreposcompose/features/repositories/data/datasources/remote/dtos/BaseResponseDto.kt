package com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.dtos

import com.google.gson.annotations.SerializedName

data class BaseResponseDto<T>(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val areResultsIncomplete: Boolean,
    @SerializedName("items")
    val items: List<T>
)