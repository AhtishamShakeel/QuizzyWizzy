package com.example.quizzywizzy

import android.os.Bundle
import androidx.fragment.app.Fragment

class TopicsFragment : Fragment() {
    companion object {
        fun newInstance(categoryId: Int) = TopicsFragment().apply {
            arguments = Bundle().apply {
                putInt("categoryId", categoryId)
            }
        }
    }
}