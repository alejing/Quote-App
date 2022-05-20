package com.example.quotesapp.domain

import com.example.quotesapp.data.model.QuoteModel
import com.example.quotesapp.data.model.QuoteRepository

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}