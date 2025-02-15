package com.example.quizzywizzy.quiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    var selectedCategory: String? = null
    var selectedTopic: String? = null
    var selectedSubTopic: String? = null
    var selectedDifficulty: String? = null
}