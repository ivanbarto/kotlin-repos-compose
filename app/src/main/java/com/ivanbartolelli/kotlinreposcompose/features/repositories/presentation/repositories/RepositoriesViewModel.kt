package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.repos.RepositoriesRepo
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(private val paginatedRepositoriesRepo: RepositoriesRepo) :
    ViewModel() {

    val repositories = paginatedRepositoriesRepo.getRepositories().cachedIn(viewModelScope)

    fun getRepository(id : Long) : Repository = paginatedRepositoriesRepo.getRepository(id)

    suspend fun clearRepositoriesCache() {
        paginatedRepositoriesRepo.clearRepositoriesCache()
    }

}