package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.*

class ShoppingViewModel:ViewModel() {

    private val repository = ShoppingRepository

    private var _itemList : MutableLiveData<ArrayList<ShoppingItem>> = MutableLiveData(arrayListOf())
    val itemList get() = _itemList

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}