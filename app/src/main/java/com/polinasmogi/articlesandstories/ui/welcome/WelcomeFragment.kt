package com.polinasmogi.articlesandstories.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.polinasmogi.articlesandstories.R
import com.polinasmogi.articlesandstories.databinding.FragmentWelcomeBinding
import com.polinasmogi.articlesandstories.ui.article.ArticleFragment
import com.polinasmogi.articlesandstories.ui.article_list.ArticleListFragment
import com.polinasmogi.articlesandstories.ui.content.ContentFragment

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.articlesButton.setOnClickListener { openContent(ArticleListFragment.Types.ARTICLES.id) }
        binding.storiesButton.setOnClickListener { openContent(ArticleListFragment.Types.STORIES.id) }
        binding.visitedButton.setOnClickListener { openContent(ArticleListFragment.Types.VISITED.id) }

    }

    private fun openContent(type: Int) {
        val bundle = Bundle()
        bundle.putInt(ContentFragment.TYPE, type)
        findNavController().navigate(R.id.action_WelcomeFragment_to_ContentFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}