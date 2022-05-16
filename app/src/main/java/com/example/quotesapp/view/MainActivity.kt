package com.example.quotesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.quotesapp.databinding.ActivityMainBinding
import com.example.quotesapp.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Connect the UI (XML) with MainActivity.kt
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data connection with LiveData
        quoteViewModel.quoteModel.observe(this) { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        }

        binding.viewContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}