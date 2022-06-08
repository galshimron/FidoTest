package com.gs.fidotest.ui.news_articals_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.gs.fidotest.R
import com.gs.fidotest.di.interfaces.OnNewsArticleClick
import com.gs.fidotest.di.models.ArticleModel

class NewsArticleAdapter(private val onNewsArticleClick:OnNewsArticleClick) : ListAdapter<ArticleModel,ArticleModelViewHolder>(ArticleDiffUtil()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleModelViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val inflate = layoutInflater.inflate(R.layout.article_view_holder_layout, parent, false)
        return ArticleModelViewHolder(inflate)

    }

    override fun onBindViewHolder(holder: ArticleModelViewHolder, position: Int) {

        holder.onBind(currentList[position], onNewsArticleClick)
    }

}
