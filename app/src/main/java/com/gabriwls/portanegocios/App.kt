package com.gabriwls.portanegocios

import android.app.Application
import com.gabriwls.portanegocios.data.AppDatabase
import com.gabriwls.portanegocios.data.BusinessCardRepository

class App : Application() {
    val database by lazy {
        AppDatabase.getDatabase(this)
    }
    val repository by lazy {
        BusinessCardRepository(database.businessDao())
    }
}