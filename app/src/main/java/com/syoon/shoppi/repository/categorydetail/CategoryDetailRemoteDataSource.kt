package com.syoon.shoppi.repository.categorydetail

import com.syoon.shoppi.model.CategoryDetail
import com.syoon.shoppi.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}