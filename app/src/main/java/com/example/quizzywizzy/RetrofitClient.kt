package com.example.quizzywizzy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://quizverse.pythonanywhere.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val instance:QuizApiService by lazy{
        retrofit.create(QuizApiService::class.java)

    }
}