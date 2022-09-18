package com.polinasmogi.articlesandstories.ui.article_list

import com.polinasmogi.articlesandstories.models.ContentItem

sealed class ArticleListViewState

data class ShowList(val contents: List<ContentItem>) : ArticleListViewState()
data class ShowContent(val objectId: String) : ArticleListViewState()
