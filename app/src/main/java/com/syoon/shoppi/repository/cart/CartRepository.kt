package com.syoon.shoppi.repository.cart

import com.syoon.shoppi.model.CartItem
import com.syoon.shoppi.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartRepository(
    private val localDataSource: CartItemLocalDataSource
) {

    suspend fun addCartItem(product: Product) {
        withContext(Dispatchers.IO) {
            val cartItem = CartItem(
                productId = product.productId,
                label = product.label,
                price = product.price,
                brandName = product.brandName ?: "",
                thumbnailImageUrl = product.thumbnailImageUrl ?: "",
                type = product.type ?: "",
                amount = 1
            )
            localDataSource.addCartItem(cartItem)
        }
    }

    suspend fun getCartItems(): List<CartItem> {
        return withContext(Dispatchers.IO) {
            localDataSource.getCartItems()
        }
    }
}