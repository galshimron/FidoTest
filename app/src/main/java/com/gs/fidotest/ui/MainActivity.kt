package com.gs.fidotest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gs.fidotest.R
import com.gs.fidotest.ui.news_articals_list.NewsArticleListFragment

class MainActivity : AppCompatActivity() {

    companion object{
        const val NEWS_LIST_FRAGMENT =  "NewsListFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.containerNewsActivity, NewsArticleListFragment(), "NewsListFragment" ).addToBackStack("NewsListFragment").commit()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.fragments.isEmpty() || ( supportFragmentManager.fragments.size == 1 && supportFragmentManager.fragments[0].tag.toString() == NEWS_LIST_FRAGMENT ) ){
            finish()
        }else {
            super.onBackPressed()
        }
    }

}