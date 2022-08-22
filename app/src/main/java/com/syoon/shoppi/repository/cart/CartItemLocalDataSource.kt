package com.syoon.shoppi.repository.cart

import com.syoon.shoppi.database.CartItemDao
import com.syoon.shoppi.model.CartItem

class CartItemLocalDataSource(private val dao: CartItemDao) : CartItemDataSource {

    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }
}