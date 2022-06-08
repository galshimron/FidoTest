package com.gs.fidotest.ui.news_articals_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gs.fidotest.R
import com.gs.fidotest.di.interfaces.OnNewsArticleClick
import com.gs.fidotest.di.models.ArticleModel

class ArticleModelViewHolder(articleView:View):RecyclerView.ViewHolder(articleView)  {
    private val title: TextView = itemView.findViewById<TextView>(R.id.tvTitle)
    private val author: TextView = itemView.findViewById<TextView>(R.id.tvAuthor)
    private val description: TextView =  itemView.findViewById<TextView>(R.id.tvDescription)

    fun onBind(currentItem: ArticleModel, itemClick:OnNewsArticleClick) {
        title.text = currentItem.title
        author.text = currentItem.author
        description.text = currentItem.description
        itemView.setOnClickListener {
           itemClick.onClick(currentItem)
        }
    }

}
