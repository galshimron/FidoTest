package com.gs.fidotest.ui.news_articals_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gs.fidotest.di.api.RetrofitHelper
import com.gs.fidotest.di.models.ArticlesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsArticleListViewModel:ViewModel() {

    val TAG = "NewsArticleListVM"
    private val _articleListRes = MutableLiveData<ArticlesModel>()
    val articleListRes :LiveData<ArticlesModel> = _articleListRes


    fun getNewArticleList(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val getNewArticleList  = RetrofitHelper.getInstance().getArticles()
                _articleListRes.postValue(getNewArticleList)
            }catch (e:Exception){
                Log.e(TAG, "getNewArticleList: Exception ${e.message} \n, ${e.stackTraceToString()}  " )
            }

        }
    }

}
