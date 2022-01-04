package com.example.roomdatabasekotlin

import android.app.Application
import com.example.roomdatabasekotlin.api.QuoteService
import com.example.roomdatabasekotlin.api.RetrofitHelper
import com.example.roomdatabasekotlin.db.QuoteDatabase
import com.example.roomdatabasekotlin.repository.QuoteRepository



class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize(){
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService,database,applicationContext)

    }

}