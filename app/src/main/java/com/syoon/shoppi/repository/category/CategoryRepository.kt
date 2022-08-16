package com.syoon.shoppi.repository.category

import com.syoon.shoppi.model.Category

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {

    suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCategories()
    }
}