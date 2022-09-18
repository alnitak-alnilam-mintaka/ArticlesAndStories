package com.polinasmogi.articlesandstories.di

import androidx.room.Room
import com.polinasmogi.articlesandstories.database.ContentDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), ContentDatabase::class.java, ContentDatabase.DATABASE_NAME).build()
    }
    single { get<ContentDatabase>().contentDao() }
}