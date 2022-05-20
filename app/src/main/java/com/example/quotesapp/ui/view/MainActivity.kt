package com.example.quotesapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.quotesapp.databinding.ActivityMainBinding
import com.example.quotesapp.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Connect the UI (XML) with MainActivity.kt
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load the first quote from the web service
        quoteViewModel.onCreate()

        // Data connection with LiveData
        quoteViewModel.quoteModel.observe(this) { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        }

        // Controls how the progress bar works
        quoteViewModel.isLoading.observe(this  ){
            binding.progress.isVisible = it
        }

        binding.viewContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}