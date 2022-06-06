package com.example.kursprogin.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kursprogin.data.room.dto.FavouriteDto


@Database(
    entities = [FavouriteDto::class],
    version = 1
)
abstract class DbRoom : RoomDatabase() {
    abstract fun getFavouriteDao(): FavouriteDao

    companion object{
        @Volatile
        private var instance: DbRoom? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DbRoom::class.java,
                "favourite_database.db"
            ).build()
    }
}
