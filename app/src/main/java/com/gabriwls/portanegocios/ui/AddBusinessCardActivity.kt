package com.gabriwls.portanegocios.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gabriwls.portanegocios.App
import com.gabriwls.portanegocios.R
import com.gabriwls.portanegocios.data.BusinessCard
import com.gabriwls.portanegocios.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAddBusinessCardBinding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
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
            val newBusinessCard = BusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                telefone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                empresa = binding.tilBusinessName.editText?.text.toString(),
                fundoPersonalizado = R.color.primary_200.toString()
            )
            mainViewModel.insert(newBusinessCard)
            Toast.makeText(this, R.string.tst_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}