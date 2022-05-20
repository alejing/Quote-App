package com.example.quotesapp.data.model

import com.example.quotesapp.data.model.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel> {
        val response = api.getQuotes()  // call the backend
        QuoteProvider.quotes = response // save data on memory
        return response
    }
}