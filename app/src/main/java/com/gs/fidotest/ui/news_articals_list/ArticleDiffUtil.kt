package com.gs.fidotest.ui.news_articals_list

import androidx.recyclerview.widget.DiffUtil
import com.gs.fidotest.di.models.ArticleModel

class ArticleDiffUtil : DiffUtil.ItemCallback<ArticleModel>() {


    override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        //IF BOTH of the id's are null we still can not determine that the items are the same
        return !(null == oldItem.source.id || null == newItem.source.id || oldItem.source.id != newItem.source.id)
    }

    override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem == newItem
    }

}
