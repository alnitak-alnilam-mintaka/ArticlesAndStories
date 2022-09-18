package com.polinasmogi.articlesandstories.ui.article_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polinasmogi.articlesandstories.databinding.ItemArticleBinding
import com.polinasmogi.articlesandstories.models.ContentItem

class ContentAdapter(
    private val onClickAction: (Int) -> Unit
) : RecyclerView.Adapter<ContentViewHolder>() {

    private val items = arrayListOf<ContentItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding, onClickAction)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun build(list: List<ContentItem>?) {
        list?.let {
            items.clear()
            items.addAll(it)
            notifyDataSetChanged()
        }
    }



}