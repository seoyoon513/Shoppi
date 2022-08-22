package com.syoon.shoppi.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syoon.shoppi.AssetLoader
import com.syoon.shoppi.repository.category.CategoryRemoteDataSource
import com.syoon.shoppi.repository.category.CategoryRepository
import com.syoon.shoppi.repository.home.HomeAssetDataSource
import com.syoon.shoppi.repository.home.HomeRepository
import com.syoon.shoppi.ui.category.CategoryViewModel
import com.syoon.shoppi.ui.home.HomeViewModel
import com.syoon.shoppi.ServiceLocator
import com.syoon.shoppi.repository.cart.CartItemLocalDataSource
import com.syoon.shoppi.repository.cart.CartRepository
import com.syoon.shoppi.repository.categorydetail.CategoryDetailRemoteDataSource
import com.syoon.shoppi.repository.categorydetail.CategoryDetailRepository
import com.syoon.shoppi.repository.productdetail.ProductDetailRemoteDataSource
import com.syoon.shoppi.repository.productdetail.ProductDetailRepository
import com.syoon.shoppi.ui.cart.CartViewModel
import com.syoon.shoppi.ui.categorydetail.CategoryDetailViewModel
import com.syoon.shoppi.ui.productdetail.ProductDetailViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
                CategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(
                    ServiceLocator.provideApiClient()))
                CategoryDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository = ProductDetailRepository(ProductDetailRemoteDataSource(
                    ServiceLocator.provideApiClient()))
                ProductDetailViewModel(repository, ServiceLocator.provideCartRepository(context)) as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(ServiceLocator.provideCartRepository(context)) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}