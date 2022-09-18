package com.polinasmogi.articlesandstories.ui.article_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.articlesandstories.database.toContentItem
import com.polinasmogi.articlesandstories.database.toContentItemList
import com.polinasmogi.articlesandstories.models.ArticlesResponseModel
import com.polinasmogi.articlesandstories.models.ContentItem
import com.polinasmogi.articlesandstories.models.Hit
import com.polinasmogi.articlesandstories.repositories.ArticlesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleListViewModel (
    private val repository: ArticlesRepository
): ViewModel() {

    private val _contentData = MutableLiveData<ArticleListViewState>()
    val contentData: LiveData<ArticleListViewState> = _contentData

    private val _errorData = MutableLiveData<String>()
    val errorData: LiveData<String> = _errorData

    private var contents = arrayListOf<Hit>()

    fun getContents(type: ArticleListFragment.Types) {
        when (type) {
            ArticleListFragment.Types.ARTICLES -> repository.getArticles().enqueue(callback)
            ArticleListFragment.Types.STORIES -> repository.getStories().enqueue(callback)
            ArticleListFragment.Types.VISITED -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val contents = repository.getVisited()
                    launch(Dispatchers.Main) {
                        _contentData.value = ShowList(contents.toContentItem())
                    }
                }
            }
        }
    }

    private val callback = object : Callback<ArticlesResponseModel> {
        override fun onResponse(
            call: Call<ArticlesResponseModel>,
            response: Response<ArticlesResponseModel>
        ) {
            if (response.isSuccessful) {
                viewModelScope.launch(Dispatchers.Main) {
                    response.body()?.let {
                        if (it.hits.isNotEmpty()) {
                            contents.clear()
                            contents.addAll(it.hits)
                            _contentData.value = ShowList(it.hits.toContentItemList())
                        } else {
                            _errorData.value = "There is no content. Try again later."
                        }
                    } ?: showGenericError()
                }
            } else {
                showGenericError()
            }
        }
        override fun onFailure(call: Call<ArticlesResponseModel>, t: Throwable) {
            _errorData.value = t.message
        }
    }

    fun onElementClick(position: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.onContentWasShown(contents[position])
        }
        _contentData.value = ShowContent(contents[position].objectID)
    }

    private fun showGenericError() {
        _errorData.value = "Something went wrong. Please try again later"
    }

}