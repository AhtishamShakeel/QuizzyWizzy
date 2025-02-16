package com.example.quizzywizzy

import android.adservices.adid.AdId
import retrofit2.http.GET
import retrofit2.http.Query


interface QuizApiService {
    // Categories
    @GET("/")
    suspend fun getAllCategories(): List<Category>

    // Topics for a category
    @GET("topic/")
    suspend fun getTopicsByCategory(@Query("category") categoryId: Int): List<Topic>

    // Subtopics for a topic
    @GET("subtopics")
    suspend fun getQuizByTopics(@Query("topic") topicId: Int): List<Quiz>

    // Questions for a subtopic
    @GET("questions")
    suspend fun getQuestionsByQuiz(@Query("quiz") quizId: Int): List<Question>

}