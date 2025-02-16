package com.example.quizzywizzy

data class Question(
    val id: Int,
    val statement: String,
    val option_a: String?,
    val option_b: String?,
    val option_c: String?,
    val option_d: String?,
    val answer: String,
    val difficulty: String,
    val quiz: Int  // Reference to Subtopic ID
)