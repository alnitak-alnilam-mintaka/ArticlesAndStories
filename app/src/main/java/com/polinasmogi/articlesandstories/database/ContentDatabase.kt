package com.polinasmogi.articlesandstories.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ ContentEntity::class ], version = 2, exportSchema = true)
abstract class ContentDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDao

    companion object {
        const val DATABASE_NAME = "content_database"
    }

}