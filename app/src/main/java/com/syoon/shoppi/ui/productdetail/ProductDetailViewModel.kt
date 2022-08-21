package com.syoon.shoppi.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syoon.shoppi.model.Product
import com.syoon.shoppi.repository.productdetail.ProductDetailRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository
): ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product


    fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            val productDetail = productDetailRepository.getProductDetail(productId)
            _product.value = productDetail
        }
    }
}