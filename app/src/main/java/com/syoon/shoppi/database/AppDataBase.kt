package com.syoon.shoppi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.syoon.shoppi.model.CartItem

@Database(entities = [CartItem::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao
}