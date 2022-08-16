package com.syoon.shoppi.repository.category

import com.syoon.shoppi.model.Category

interface CategoryDataResource {

    suspend fun getCategories(): List<Category>
}