package com.syoon.shoppi.repository.categorydetail

import com.syoon.shoppi.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}