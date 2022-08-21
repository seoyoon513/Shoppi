package com.syoon.shoppi.repository.productdetail

import com.syoon.shoppi.model.Product

interface ProductDetailDataResource {

    suspend fun getProductDetail(productId: String): Product
}