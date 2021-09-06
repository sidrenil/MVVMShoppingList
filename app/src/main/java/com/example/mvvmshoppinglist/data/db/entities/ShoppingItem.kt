package com.example.mvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "aitem_name")
    var name: String,
    @ColumnInfo(name = "aitem_amount")
    var amount: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)