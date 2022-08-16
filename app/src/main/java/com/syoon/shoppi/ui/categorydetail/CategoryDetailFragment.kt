package com.syoon.shoppi.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syoon.shoppi.databinding.FragmentCategoryDetailBinding
import com.syoon.shoppi.databinding.FragmentHomeBinding
import com.syoon.shoppi.ui.common.KEY_CATEGORY_ID
import com.syoon.shoppi.ui.common.KEY_CATEGORY_LABEL

class CategoryDetailFragment: Fragment() {

    private lateinit var binding: FragmentCategoryDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        val categoryId = requireArguments().getString(KEY_CATEGORY_ID)
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
    }
}