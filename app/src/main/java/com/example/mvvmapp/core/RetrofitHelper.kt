package com.example.mvvmapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofitQuote(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getRetrofitContainer(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://containerlist-af82c-default-rtdb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}