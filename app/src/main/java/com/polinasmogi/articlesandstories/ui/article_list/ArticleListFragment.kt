package com.polinasmogi.articlesandstories.ui.article_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.polinasmogi.articlesandstories.R
import com.polinasmogi.articlesandstories.databinding.FragmentArticleListBinding
import com.polinasmogi.articlesandstories.ui.article.ArticleFragment
import com.polinasmogi.articlesandstories.ui.article_list.adapter.ContentAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ArticleListFragment  : Fragment() {

    private val viewModel: ArticleListViewModel by viewModel()

    private var _binding: FragmentArticleListBinding? = null
    private val binding get() = _binding!!

    private lateinit var type: Types

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.contentData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ShowContent -> {
                    val bundle = Bundle()
                    bundle.putString(ArticleFragment.OBJECT_ID, state.objectId)
                    findNavController().navigate(R.id.action_ArticleListFragment_to_ArticleFragment, bundle)
                }
                is ShowList -> {
                    val adapter = ContentAdapter(::onElementClick)
                    adapter.build(state.contents)
                    binding.contentRecycler.adapter = adapter
                    binding.apply {
                        contentRecycler.adapter = adapter
                        contentRecycler.visibility = View.VISIBLE
                        errorMessage.visibility = View.GONE
                    }
                }
            }
        }
        viewModel.errorData.observe(viewLifecycleOwner) { message ->
            binding.apply {
                contentRecycler.visibility = View.GONE
                errorMessage.visibility = View.VISIBLE
                errorMessage.text = message
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (::type.isInitialized) {
            viewModel.getContents(type)
        }
    }

    override fun onResume() {
        super.onResume()
        if (::type.isInitialized) {
            viewModel.getContents(type)
        }
    }

    private fun onElementClick(position: Int) {
        viewModel.onElementClick(position)
    }

    fun createFragment(type: Types): Fragment {
        this.type = type
        return this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    enum class Types(val id: Int) {
        ARTICLES(0), STORIES(1), VISITED(2)
    }

}