package com.polinasmogi.articlesandstories.models

data class ContentItem(
    val id: String,
    val title: String,
    val points: Int,
    val views: Int? = null
)
