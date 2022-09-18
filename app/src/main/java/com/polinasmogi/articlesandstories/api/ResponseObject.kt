package com.polinasmogi.articlesandstories.api

data class ResponseObject<T>(
    val isSuccessful: Boolean,
    val body: T?,
    val errorMessage: String?
)
