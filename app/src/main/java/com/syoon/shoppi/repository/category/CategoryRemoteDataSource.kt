package com.syoon.shoppi.repository.category

import com.syoon.shoppi.model.Category
import com.syoon.shoppi.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataResource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}