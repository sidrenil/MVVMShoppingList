package com.example.mvvmshoppinglist.ui.shoppinglist


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.*

class ShoppingViewModel:ViewModel() {

    private val repository = ShoppingRepository

    val itemList = getAllShoppingItems()

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    private fun getAllShoppingItems() = repository.getAllShoppingItems()
}