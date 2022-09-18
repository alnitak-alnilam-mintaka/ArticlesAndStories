package com.polinasmogi.articlesandstories.api

import com.polinasmogi.articlesandstories.models.ArticlesResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("v1/search")
    fun getArticlesList(@Query("tags") tags: String): Call<ArticlesResponseModel>

    @GET("v1/search_by_date")
    fun getStories(@Query("tags") tags: String) : Call<ArticlesResponseModel>

}