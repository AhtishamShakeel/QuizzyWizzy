package com.example.quizzywizzy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment


class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val startbuttom = view.findViewById<Button>(R.id.btnStartQuiz)
        startbuttom.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CategoryFragment())
                .addToBackStack(null)
                .commit()


        }
        return view
    }
}