package com.gabriwls.portanegocios.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gabriwls.portanegocios.App
import com.gabriwls.portanegocios.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy {
        BusinessCardAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCards()
        insertListeners()
    }

    private fun insertListeners() {
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllBusinessCards() {
        mainViewModel.getAll().observe(this) { businessCards ->
            adapter.submitList(businessCards)
        }
    }
}