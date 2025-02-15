package com.example.quizzywizzy.selection

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizzywizzy.R
import com.example.quizzywizzy.quiz.QuizViewModel

class CategoryFragment : Fragment() {
    private val quizViewModel: QuizViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.category1).setOnClickListener {selectCategory("Mathemathics")}
        view.findViewById<Button>(R.id.category2).setOnClickListener {selectCategory("Science")}
        view.findViewById<Button>(R.id.category3).setOnClickListener {selectCategory("English Language")}
        view.findViewById<Button>(R.id.category4).setOnClickListener {selectCategory("Urdu Language")}
        view.findViewById<Button>(R.id.category5).setOnClickListener {selectCategory("Pakistan Studies")}
        view.findViewById<Button>(R.id.category6).setOnClickListener {selectCategory("Islamic Studies")}
        view.findViewById<Button>(R.id.category7).setOnClickListener {selectCategory("General Knowledge")}
    }

    private fun selectCategory(category: String) {
        quizViewModel.selectedCategory = category
        findNavController().navigate(R.id.action_categoryFragment_to_topicFragment)
    }
}