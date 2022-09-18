package com.polinasmogi.articlesandstories.di

import com.polinasmogi.articlesandstories.database.ContentSource
import com.polinasmogi.articlesandstories.repositories.ArticlesRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule : Module = module {
    single { ArticlesRepository(get(), get()) }
    single { ContentSource(get()) }
}