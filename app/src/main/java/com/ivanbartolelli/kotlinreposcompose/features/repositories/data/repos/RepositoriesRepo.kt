package com.ivanbartolelli.kotlinreposcompose.features.repositories.data.repos

import androidx.paging.PagingData
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository
import kotlinx.coroutines.flow.Flow

interface RepositoriesRepo {
    fun getRepositories(): Flow<PagingData<Repository>>
    fun getRepository(id : Long): Repository
}