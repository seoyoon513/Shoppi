package com.syoon.shoppi.ui.productdetail

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.syoon.shoppi.databinding.FragmentProductDetailBinding
import com.syoon.shoppi.ui.common.EventObserver
import com.syoon.shoppi.ui.common.KEY_PRODUCT_ID
import com.syoon.shoppi.ui.common.ViewModelFactory

class ProductDetailFragment: Fragment() {

    private val viewModel: ProductDetailViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentProductDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        setNavigation()
        requireArguments().getString(KEY_PRODUCT_ID)?.let { productId ->
            setLayout(productId)
        }
        setAddCart()

//        val productId = requireArguments().getString(KEY_PRODUCT_ID)
//        Log.d("ProductDetailFragment", "productId=$productId")
    }
    private fun setAddCart() {
        viewModel.addCartEvent.observe(viewLifecycleOwner, EventObserver {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("장바구니에 상품이 담겼습니다")
                .setPositiveButton("확인"
                ) { dialog, which ->

                }
                .show()

        })
    }

    private fun setNavigation() {
        binding.toolbarProductDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setLayout(productId: String) {
        viewModel.loadProductDetail(productId)
        val descriptionAdapter = ProductDetailAdapter()
        binding.rvProductDetail.adapter = descriptionAdapter
        viewModel.product.observe(viewLifecycleOwner) { product ->
            binding.product = product
            descriptionAdapter.submitList(product.descriptions)
        }

    }
}