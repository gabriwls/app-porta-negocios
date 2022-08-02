package com.gabriwls.portanegocios.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabriwls.portanegocios.R
import com.gabriwls.portanegocios.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAddBusinessCardBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btClose.setOnClickListener {
            finish()
        }

        binding.btSave.setOnClickListener {

        }
    }
}