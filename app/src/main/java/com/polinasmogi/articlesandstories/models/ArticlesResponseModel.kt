package com.polinasmogi.articlesandstories.models

import com.google.gson.annotations.SerializedName

data class ArticlesResponseModel (

    @SerializedName("hits"                ) val hits                : ArrayList<Hit>,
    @SerializedName("nbHits"              ) val nbHits              : Int?,
    @SerializedName("page"                ) val page                : Int?,
    @SerializedName("nbPages"             ) val nbPages             : Int?,
    @SerializedName("hitsPerPage"         ) val hitsPerPage         : Int?,
    @SerializedName("exhaustiveNbHits"    ) val exhaustiveNbHits    : Boolean?,
    @SerializedName("exhaustiveTypo"      ) val exhaustiveTypo      : Boolean?,
    @SerializedName("exhaustive"          ) val exhaustive          : Exhaustive?,
    @SerializedName("query"               ) val query               : String?,
    @SerializedName("params"              ) val params              : String?,
    @SerializedName("processingTimeMS"    ) val processingTimeMS    : Int?,
    @SerializedName("processingTimingsMS" ) val processingTimingsMS : ProcessingTimingsMS?

)

data class Hit(

    @SerializedName("created_at"       ) val createdAt: String,
    @SerializedName("title"            ) val title: String,
    @SerializedName("url"              ) val url: String?,
    @SerializedName("author"           ) val author: String,
    @SerializedName("points"           ) val points: Int,
    @SerializedName("story_text"       ) val storyText: String?,
    @SerializedName("comment_text"     ) val commentText: String?,
    @SerializedName("num_comments"     ) val numComments: Int,
    @SerializedName("story_id"         ) val storyId: String?,
    @SerializedName("story_title"      ) val storyTitle: String?,
    @SerializedName("story_url"        ) val storyUrl: String?,
    @SerializedName("parent_id"        ) val parentId: String?,
    @SerializedName("created_at_i"     ) val createdAtI: Int,
    @SerializedName("_tags"            ) val tags: ArrayList<String>,
    @SerializedName("objectID"         ) val objectID: String,
    @SerializedName("_highlightResult" ) val highlightResult: HighlightResult?

)

data class HighlightResult (

    @SerializedName("title"  ) val title  : Title?,
    @SerializedName("url"    ) val url    : Url?,
    @SerializedName("author" ) val author : Author?

)

data class Title (

    @SerializedName("value"        ) val value        : String?,
    @SerializedName("matchLevel"   ) val matchLevel   : String?,
    @SerializedName("matchedWords" ) val matchedWords : ArrayList<String>

)

data class Url (

    @SerializedName("value"        ) val value        : String?,
    @SerializedName("matchLevel"   ) val matchLevel   : String?,
    @SerializedName("matchedWords" ) val matchedWords : ArrayList<String>

)

data class Author (

    @SerializedName("value"        ) val value        : String?,
    @SerializedName("matchLevel"   ) val matchLevel   : String?,
    @SerializedName("matchedWords" ) val matchedWords : ArrayList<String>

)

data class Exhaustive (

    @SerializedName("nbHits" ) val nbHits : Boolean?,
    @SerializedName("typo"   ) val typo   : Boolean?

)

data class ProcessingTimingsMS (

    @SerializedName("afterFetch" ) val afterFetch : AfterFetch?,
    @SerializedName("total"      ) val total      : Int?

)

data class AfterFetch (

    @SerializedName("total" ) val total : Int?

)

