package com.gs.fidotest.di.interfaces

import com.gs.fidotest.di.models.ArticleModel

interface OnNewsArticleClick {

    fun onClick(articleModel: ArticleModel)
}