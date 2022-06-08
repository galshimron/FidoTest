package com.gs.fidotest.di.api

import com.gs.fidotest.di.models.ArticleModel
import com.gs.fidotest.di.models.ArticlesModel
import retrofit2.Response
import retrofit2.http.GET

//API EXAMPLE
//GET https://newsapi.org/v2/everything?q=Apple&from=2022-06-08&sortBy=popularity&apiKey=API_KEY
interface NewApi {
    @GET("everything?q=Android&from=2022-06-08&sortBy=popularity&apiKey=01301238f0074c41a68d9c7f889d4217")
    suspend fun getArticles():ArticlesModel
}