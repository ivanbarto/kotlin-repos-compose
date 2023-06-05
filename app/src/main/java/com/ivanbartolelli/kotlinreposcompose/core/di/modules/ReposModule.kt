package com.ivanbartolelli.kotlinreposcompose.core.di.modules

import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.RepositoriesDatabase
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.remote.services.RepositoriesService
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.repos.RepositoriesRepo
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.repos.RepositoriesRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ReposModule {

    @Singleton
    @Provides
    fun provideRepositoriesRepo(service: RepositoriesService, database: RepositoriesDatabase): RepositoriesRepo {
        return RepositoriesRepoImpl(service, database)
    }
}