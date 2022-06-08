package com.gs.fidotest.di.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitHelper {

    val baseUrl ="https://newsapi.org/v2/"

    fun getInstance(): NewApi {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                                .create<NewApi>()
    }

}