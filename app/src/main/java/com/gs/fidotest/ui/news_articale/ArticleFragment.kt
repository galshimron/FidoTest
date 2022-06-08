package com.gs.fidotest.ui.news_articale

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gs.fidotest.R
import com.gs.fidotest.databinding.ArticleFragmentLayoutBinding

class ArticleFragment : Fragment() {

    companion object{
        const val TITLE = "title"
        const val CONTENT = "content"

        fun newInstance(title: String, content: String): ArticleFragment {
            val args = Bundle()

            args.putString(TITLE, title)
            args.putString(CONTENT, content)

            val articleFragment = ArticleFragment()
            articleFragment.arguments = args
            return articleFragment
        }
    }

    lateinit var articleFragmentLayoutBinding:ArticleFragmentLayoutBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articleFragmentLayoutBinding = DataBindingUtil.inflate<ArticleFragmentLayoutBinding>(layoutInflater, R.layout.article_fragment_layout, container, false)
        return articleFragmentLayoutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleFragmentLayoutBinding?.apply {
            tvArticleTitle.text = arguments?.getString(TITLE)   ?: ""
            tvArticleText.text = arguments?.getString(CONTENT) ?: ""
        }
    }
}
