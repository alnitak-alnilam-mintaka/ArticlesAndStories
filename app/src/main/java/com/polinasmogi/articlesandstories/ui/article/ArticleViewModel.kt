package com.polinasmogi.articlesandstories.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.articlesandstories.database.toHit
import com.polinasmogi.articlesandstories.models.Hit
import com.polinasmogi.articlesandstories.repositories.ArticlesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleViewModel (
    private val repository: ArticlesRepository
): ViewModel() {

    private val _contentData = MutableLiveData<Hit>()
    val contentData: LiveData<Hit> = _contentData

    private val _errorData = MutableLiveData<String>()
    val errorData: LiveData<String> = _errorData

    fun getContent(objectId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val content = repository.getTheContentById(objectId)?.toHit()
            launch(Dispatchers.Main) {
                content?.let {
                    _contentData.value = it
                }
            }
        }
    }

    private fun showGenericError() {
        _errorData.value = "Something went wrong. Please try again later"
    }

}