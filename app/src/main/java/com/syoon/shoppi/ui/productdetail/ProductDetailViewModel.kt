package com.syoon.shoppi.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syoon.shoppi.model.Product
import com.syoon.shoppi.repository.cart.CartRepository
import com.syoon.shoppi.repository.productdetail.ProductDetailRepository
import com.syoon.shoppi.ui.common.Event
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository: CartRepository
): ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    private val _addCartEvent = MutableLiveData<Event<Unit>>()
    val addCartEvent: LiveData<Event<Unit>> = _addCartEvent


    fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            val productDetail = productDetailRepository.getProductDetail(productId)
            _product.value = productDetail
        }
    }

    fun addCart(product: Product) {
        viewModelScope.launch {
            cartRepository.addCartItem(product)
            _addCartEvent.value = Event(Unit)
        }

    }    }