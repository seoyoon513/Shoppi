package com.syoon.shoppi

import android.content.Context
import androidx.room.Room
import com.syoon.shoppi.database.AppDataBase
import com.syoon.shoppi.network.ApiClient
import com.syoon.shoppi.repository.cart.CartItemLocalDataSource
import com.syoon.shoppi.repository.cart.CartRepository

object ServiceLocator {

    private var apiClient: ApiClient? = null
    private var dataBase: AppDataBase? = null
    private var cartRepository: CartRepository? = null

    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }

    fun provideDatabase(applicationContext: Context): AppDataBase {
        return dataBase ?: kotlin.run {
            Room.databaseBuilder(
                applicationContext,
                AppDataBase::class.java,
                "shoppi-local"
            ).build().also {
                dataBase = it
            }

        }
    }

    fun provideCartRepository(context: Context): CartRepository {
        return cartRepository ?: kotlin.run {
            val dao = provideDatabase(context.applicationContext).cartItemDao()
            CartRepository(CartItemLocalDataSource(dao)). also {
                cartRepository = it
            }
        }
    }
}