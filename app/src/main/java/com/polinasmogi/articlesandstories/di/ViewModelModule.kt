package com.polinasmogi.articlesandstories.di

import com.polinasmogi.articlesandstories.ui.article.ArticleViewModel
import com.polinasmogi.articlesandstories.ui.article_list.ArticleListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {
    viewModel { ArticleListViewModel(get()) }
    viewModel { ArticleViewModel(get()) }
}