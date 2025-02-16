package com.example.quizzywizzy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch




class CategoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_categories, container, false) // Make sure this matches your XML file name
        recyclerView = view.findViewById(R.id.rv_categories)

        loadCategories()
        return view
    }

    private fun loadCategories() {
        lifecycleScope.launch {
            try {
                val categories = RetrofitClient.instance.getAllCategories()
                activity?.runOnUiThread {
                    val adapter = CategoryAdapter(categories)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

                    // Add click listener here
                    adapter.onItemClick = { category ->
                        val topicsFragment = TopicsFragment().apply {
                            arguments = Bundle().apply {
                                putInt("categoryId", category.id)
                            }
                        }

                        parentFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, topicsFragment)
                            .addToBackStack(null)
                            .commit()
                    }
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}