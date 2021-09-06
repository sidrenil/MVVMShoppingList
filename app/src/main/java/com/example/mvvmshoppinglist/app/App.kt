package com.example.mvvmshoppinglist.app

import android.app.Application
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        ShoppingDatabase.initializeDatabase(applicationContext)
    }
}