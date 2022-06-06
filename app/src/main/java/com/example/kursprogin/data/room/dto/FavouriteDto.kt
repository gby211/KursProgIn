package com.example.kursprogin.data.room.dto

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "favouriteTable",
    indices = [Index(value = ["nameDisk"], unique = true)]
)
data class FavouriteDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nameDisk: String,
    val imageUrl: String,
)