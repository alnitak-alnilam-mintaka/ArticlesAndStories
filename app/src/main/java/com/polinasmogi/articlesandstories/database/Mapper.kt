package com.polinasmogi.articlesandstories.database

import com.polinasmogi.articlesandstories.models.ContentItem
import com.polinasmogi.articlesandstories.models.Hit

fun Hit.toContentItem() = transformToContentItem(this)
fun List<Hit>.toContentItemList() = map { it.toContentItem() }

private fun transformToContentItem(hit: Hit) = ContentItem(
    id = hit.objectID,
    title = hit.title,
    points = hit.points
)

fun Hit.toContentEntity(views: Int) = transformToEntity(this, views)

private fun transformToEntity(hit: Hit, views: Int) = ContentEntity(
    objectID = hit.objectID,
    createdAtI = hit.createdAtI,
    createdAt = hit.createdAt,
    title = hit.title,
    url = hit.url ?: "",
    author = hit.author,
    points = hit.points,
    storyText = hit.storyText,
    commentText = hit.commentText,
    numComments = hit.numComments,
    storyId = hit.storyId,
    storyTitle = hit.storyTitle,
    storyUrl = hit.storyUrl,
    parentId = hit.parentId,
    views = views
)

fun ContentEntity.toContentItem() = transform(this)
fun List<ContentEntity>.toContentItem() = map { it.toContentItem() }

private fun transform(entity: ContentEntity) = ContentItem(
    id = entity.objectID,
    title = entity.title,
    points = entity.points ?: 0,
    views = entity.views
)

fun ContentEntity.toHit() = transformToHit(this)

private fun transformToHit(contentEntity: ContentEntity) = Hit(
    createdAt = contentEntity.createdAt,
    title = contentEntity.title,
    url = contentEntity.url,
    author = contentEntity.author,
    points = contentEntity.points,
    storyText = contentEntity.storyText,
    commentText = contentEntity.commentText,
    numComments = contentEntity.numComments,
    storyId = contentEntity.storyId,
    storyTitle = contentEntity.storyTitle,
    storyUrl = contentEntity.storyUrl,
    parentId = contentEntity.parentId,
    createdAtI = contentEntity.createdAtI,
    objectID = contentEntity.objectID,
    tags = arrayListOf(),
    highlightResult = null
)


