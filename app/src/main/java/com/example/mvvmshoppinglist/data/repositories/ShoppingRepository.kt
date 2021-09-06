package com.example.mvvmshoppinglist.data.repositories

import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem

object ShoppingRepository{
    private val shoppingDao by lazy {
        ShoppingDatabase.getDatabase()?.getShoppingDao()
    }

    suspend fun upsert(item: ShoppingItem) = shoppingDao?.upsert(item)
    suspend fun delete(item: ShoppingItem) = shoppingDao?.delete(item)

    fun getAllShoppingItems() = shoppingDao?.getAllShoppingItems()
}