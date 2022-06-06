package com.example.kursprogin.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kursprogin.data.room.dto.FavouriteDto

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveFavourite(favouriteDto: FavouriteDto)

    @Query("SELECT * FROM favouriteTable")
    suspend fun getSavedFavourites(): List<FavouriteDto>

    @Delete
    suspend fun deleteFavourite(favouriteDto: FavouriteDto)
}