package com.syoon.shoppi.repository.productdetail

import com.syoon.shoppi.model.Product

class ProductDetailRepository(
    private val remoteDataSource: ProductDetailRemoteDataSource) {

    suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}