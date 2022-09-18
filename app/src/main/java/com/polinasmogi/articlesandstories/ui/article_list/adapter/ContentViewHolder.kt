package com.polinasmogi.articlesandstories.ui.article_list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.polinasmogi.articlesandstories.databinding.ItemArticleBinding
import com.polinasmogi.articlesandstories.models.ContentItem

class ContentViewHolder(
    private val binding: ItemArticleBinding,
    private val onClickAction: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(contentItem: ContentItem) {
        binding.apply {
            title.text = contentItem.title
            points.text = (contentItem.views ?: contentItem.points).toString()
            root.setOnClickListener {
                onClickAction.invoke(adapterPosition)
            }
        }
    }

}