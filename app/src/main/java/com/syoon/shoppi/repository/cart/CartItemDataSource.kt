package com.syoon.shoppi.repository.cart

import com.syoon.shoppi.model.CartItem

interface CartItemDataSource {

    suspend fun addCartItem(cartItem: CartItem)

    suspend fun getCartItems(): List<CartItem>
}