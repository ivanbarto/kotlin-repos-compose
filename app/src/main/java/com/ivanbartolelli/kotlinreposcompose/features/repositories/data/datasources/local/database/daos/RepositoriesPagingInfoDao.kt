package com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.entities.RepositoryPagingInfoEntity
import com.ivanbartolelli.kotlinreposcompose.features.repositories.data.datasources.local.database.utils.DatabaseConstants.REPOSITORY_PAGING_INFO_TABLE_NAME

@Dao
interface RepositoriesPagingInfoDao {

    @Query("DELETE FROM $REPOSITORY_PAGING_INFO_TABLE_NAME")
    suspend fun clearAll()

    @Query("SELECT * FROM $REPOSITORY_PAGING_INFO_TABLE_NAME WHERE repositoryId = :id ORDER BY timestamp ASC")
    suspend fun get(id: Long): RepositoryPagingInfoEntity

    @Query("SELECT * FROM $REPOSITORY_PAGING_INFO_TABLE_NAME ORDER BY timestamp DESC LIMIT 1")
    suspend fun getNewest(): RepositoryPagingInfoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repositoryPagingInfoEntities: List<RepositoryPagingInfoEntity>)

}