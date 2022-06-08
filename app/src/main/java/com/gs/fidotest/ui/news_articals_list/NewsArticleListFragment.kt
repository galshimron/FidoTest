package com.gs.fidotest.ui.news_articals_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gs.fidotest.R
import com.gs.fidotest.databinding.NewsArticaleListFragmentLayoutBinding
import com.gs.fidotest.di.interfaces.OnNewsArticleClick
import com.gs.fidotest.di.models.ArticleModel
import com.gs.fidotest.ui.news_articale.ArticleFragment

class NewsArticleListFragment : Fragment() , OnNewsArticleClick{

    val TAG = "NewsArticleListFragment"

    lateinit var newsArticleListFragmentLayoutBinding:NewsArticaleListFragmentLayoutBinding

    val newsArticleListViewModel: NewsArticleListViewModel by viewModels<NewsArticleListViewModel>()

    lateinit var newsArticleAdapter:NewsArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsArticleListFragmentLayoutBinding = DataBindingUtil.inflate<NewsArticaleListFragmentLayoutBinding>(layoutInflater,
            R.layout.news_articale_list_fragment_layout, container, false)
        return newsArticleListFragmentLayoutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val onNewsArticleClick = this as OnNewsArticleClick

        newsArticleListFragmentLayoutBinding?.apply {
            rcvArticleList?.apply {
                addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                newsArticleAdapter = NewsArticleAdapter(onNewsArticleClick)

                adapter = newsArticleAdapter
            }

        }



        newsArticleListViewModel.articleListRes.observe(viewLifecycleOwner){
            newsArticleAdapter.submitList(it.articles)
            Log.d(TAG, "onViewCreated: newsArticleListViewModel.articleListRes.observe(")
        }
    }

    override fun onResume() {
        super.onResume()
        newsArticleListViewModel.getNewArticleList()
    }

    override fun onClick(articleModel: ArticleModel) {
        Log.d(TAG, "onClick: articleModel title ${articleModel.title}")
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerNewsActivity, ArticleFragment.newInstance(articleModel.title, articleModel.content), "ArticleFragment").addToBackStack("ArticleFragment").commit()
    }


}
