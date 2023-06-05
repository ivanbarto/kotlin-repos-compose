package com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.entities.RepositoryEntity
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.entities.RepositoryPagingInfoEntity
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.utils.DatabaseConstants
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.utils.DatabaseConstants.REPOSITORY_TABLE_NAME
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository

@Dao
interface RepositoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<RepositoryEntity>)

    @Query("DELETE FROM $REPOSITORY_TABLE_NAME")
    suspend fun clearAll()

    @Query("SELECT * FROM $REPOSITORY_TABLE_NAME ORDER BY timestamp ASC")
    fun getRepositories(): PagingSource<Int, RepositoryEntity>

    @Query("SELECT * FROM $REPOSITORY_TABLE_NAME WHERE id = :id")
    fun get(id: Long): RepositoryEntity



}