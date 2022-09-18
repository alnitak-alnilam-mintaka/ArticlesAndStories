package com.polinasmogi.articlesandstories.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.polinasmogi.articlesandstories.databinding.FragmentArticleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleFragment  : Fragment() {

    private val viewModel: ArticleViewModel by viewModel()

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(OBJECT_ID)?.let { viewModel.getContent(it) }

        viewModel.contentData.observe(viewLifecycleOwner) { hit ->
            binding.apply {
                title.text = hit.title
                createdAt.text = hit.createdAt
                author.text = hit.author
                url.text = hit.url
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val OBJECT_ID = "objectId"
     }

}