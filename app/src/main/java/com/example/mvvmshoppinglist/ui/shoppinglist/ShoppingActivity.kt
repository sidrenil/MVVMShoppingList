package com.example.mvvmshoppinglist.ui.shoppinglist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.databinding.ActivityShoppingBinding
import com.example.mvvmshoppinglist.other.ShoppingItemAdapter


class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    private lateinit var viewModel: ShoppingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shopping)

        viewModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(arrayListOf(), viewModel)
        viewModel.itemList?.observe(this) {
            it?.let {
                adapter.setData(it as ArrayList<ShoppingItem>)
            }
        }
        binding.rvShoppingItems.adapter = adapter

        binding.fab.setOnClickListener {
            val dialog = AddShoppingItemDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                        if (item.name.isBlank()) {
                            Toast.makeText(
                                this@ShoppingActivity,
                                "Lütfen tüm bilgileri girin",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }


                    }
                })
            dialog.show()
        }

    }
}