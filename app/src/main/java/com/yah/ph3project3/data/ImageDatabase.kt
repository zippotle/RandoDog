package com.yah.ph3project3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ImageData::class], version = 1)
abstract class ImageDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDao

    companion object {
        @Volatile
        private var INSTANCE: ImageDatabase? = null
    }

    fun getDatabase(context: Context): ImageDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                ImageDatabase::class.java,
                "image_database"
            )

                .fallbackToDestructiveMigration()
                .build()
            INSTANCE = instance
            return instance
        }


    }
}

