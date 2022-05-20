package com.example.quotesapp.domain

import com.example.quotesapp.data.model.QuoteModel
import com.example.quotesapp.data.model.QuoteProvider
import com.example.quotesapp.data.model.QuoteRepository

class GetRandomQuoteUseCase {

    private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}