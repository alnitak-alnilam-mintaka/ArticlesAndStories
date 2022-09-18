package com.polinasmogi.articlesandstories.repositories

import com.polinasmogi.articlesandstories.api.APIService
import com.polinasmogi.articlesandstories.database.ContentSource
import com.polinasmogi.articlesandstories.database.toContentEntity
import com.polinasmogi.articlesandstories.models.Hit
import kotlinx.coroutines.*

class ArticlesRepository(private val contentSource: ContentSource, private val api: APIService) {

    fun getArticles() = api.getArticlesList("front_page")

    fun getStories() = api.getStories("story")

    fun getVisited() = contentSource.getVisited()

    suspend fun onContentWasShown(hit: Hit) {
        val content = contentSource.getContent(hit.objectID)
        content?.let {
            contentSource.updateContent(hit.objectID, content.views.plus(1))
        } ?: run {
            contentSource.insertContent(hit.toContentEntity(1))
        }
    }

    suspend fun getTheContentById(objectId: String) = contentSource.getContent(objectId)

}


