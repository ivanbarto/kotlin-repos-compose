package com.ivanbartolelli.kotlinreposcompose.core.di.modules

import android.app.Application
import androidx.room.Room
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.RepositoriesDatabase
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.utils.DatabaseConstants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): RepositoriesDatabase {
        return Room.databaseBuilder(application, RepositoriesDatabase::class.java, DATABASE_NAME).allowMainThreadQueries().build()
    }
}