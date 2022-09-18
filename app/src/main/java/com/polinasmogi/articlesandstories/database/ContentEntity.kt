package com.polinasmogi.articlesandstories.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contents")
data class ContentEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "objectID"         ) val objectID        : String,

    @ColumnInfo(name = "created_at"       ) val createdAt       : String,
    @ColumnInfo(name = "title"            ) val title           : String,
    @ColumnInfo(name = "url"              ) val url             : String,
    @ColumnInfo(name = "author"           ) val author          : String,
    @ColumnInfo(name = "points"           ) val points          : Int,
    @ColumnInfo(name = "story_text"       ) val storyText       : String?,
    @ColumnInfo(name = "comment_text"     ) val commentText     : String?,
    @ColumnInfo(name = "num_comments"     ) val numComments     : Int,
    @ColumnInfo(name = "story_id"         ) val storyId         : String?,
    @ColumnInfo(name = "story_title"      ) val storyTitle      : String?,
    @ColumnInfo(name = "story_url"        ) val storyUrl        : String?,
    @ColumnInfo(name = "parent_id"        ) val parentId        : String?,
    @ColumnInfo(name = "created_at_i"     ) val createdAtI      : Int,

    @ColumnInfo(name = "views"            ) val views           : Int

)