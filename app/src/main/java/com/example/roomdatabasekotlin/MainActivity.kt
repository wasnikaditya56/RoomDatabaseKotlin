package com.example.roomdatabasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasekotlin.viewmodels.MainViewModel
import com.example.roomdatabasekotlin.viewmodels.MainViewModelFactory




class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Toast.makeText(applicationContext, it.results.size.toString(),Toast.LENGTH_LONG).show()
        })



    }
}