package com.syoon.shoppi.repository.productdetail

import com.syoon.shoppi.model.Product
import com.syoon.shoppi.network.ApiClient

class ProductDetailRemoteDataSource(
    private val api: ApiClient
) : ProductDetailDataResource {

    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}