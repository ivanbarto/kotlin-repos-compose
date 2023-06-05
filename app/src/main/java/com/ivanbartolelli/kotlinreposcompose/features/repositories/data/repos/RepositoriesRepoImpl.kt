package com.ivanbartolelli.kotlinreposcompose.features.repositories.data.repos

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.RepositoriesDatabase
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.mediators.RepositoriesRemoteMediator
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.services.RepositoriesService
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.utils.RepositoriesConstants
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.toRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class RepositoriesRepoImpl(
    private val repositoriesService: RepositoriesService,
    private val database: RepositoriesDatabase
) : RepositoriesRepo {
    @OptIn(ExperimentalPagingApi::class)
    override fun getRepositories() = Pager(
        config = PagingConfig(
            pageSize = RepositoriesConstants.ITEMS_PER_PAGE,
            prefetchDistance = RepositoriesConstants.ITEMS_PREFETCH_DISTANCE
        ),
        pagingSourceFactory = {
            database.repositoriesDao().getRepositories()
        },
        remoteMediator = RepositoriesRemoteMediator(repositoriesService, database)
    ).flow.map { it.map { data -> data.toRepository() } }

    override  fun getRepository(id: Long): Repository {
        return database.repositoriesDao().get(id).toRepository()
    }

    override suspend fun clearRepositoriesCache() {
        database.clearAllTables()
    }
}


