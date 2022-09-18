package com.polinasmogi.articlesandstories.ui.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.polinasmogi.articlesandstories.R
import com.polinasmogi.articlesandstories.databinding.FragmentContentBinding
import com.polinasmogi.articlesandstories.ui.article_list.ArticleListFragment

class ContentFragment : Fragment() {

    private var _binding: FragmentContentBinding? = null
    private val binding get() = _binding!!

    private lateinit var type: ArticleListFragment.Types

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { act ->
            val adapter = ViewPagerAdapter(act.supportFragmentManager, this.lifecycle)
            val fragments = listOf(
                ArticleListFragment().createFragment(ArticleListFragment.Types.ARTICLES),
                ArticleListFragment().createFragment(ArticleListFragment.Types.STORIES),
                ArticleListFragment().createFragment(ArticleListFragment.Types.VISITED)
            )
            adapter.build(fragments)
            binding.viewPager.adapter = adapter
        }

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.articles -> binding.viewPager.setCurrentItem(0, true)
                R.id.stories -> binding.viewPager.setCurrentItem(1, true)
                R.id.favorites -> binding.viewPager.setCurrentItem(2, true)
            }
            return@setOnItemSelectedListener true
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNavigationView.selectedItemId = when (position) {
                    0 -> R.id.articles
                    1 -> R.id.stories
                    else -> R.id.favorites
                }
            }
        })

    }

    override fun onResume() {
        super.onResume()
        arguments?.getInt(TYPE)?.let {
            binding.viewPager.currentItem = it
        }
    }

    companion object {
        const val TYPE = "type"
    }

}