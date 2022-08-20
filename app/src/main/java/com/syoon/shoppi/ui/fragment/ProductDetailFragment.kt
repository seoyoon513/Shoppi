package com.syoon.shoppi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syoon.shoppi.R
import com.syoon.shoppi.ui.common.KEY_PRODUCT_ID

class ProductDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productId = requireArguments().getString(KEY_PRODUCT_ID)
        Log.d("ProductDetailFragment", "productId=$productId")
    }
}