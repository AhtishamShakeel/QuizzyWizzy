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
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        recyclerView = view.findViewById(R.id.rv_categories)

        lifecycleScope.launch {
            try {
                Log.d("API_CALL", "Attempting to fetch categories")
                val category =
                    RetrofitClient.instance.getAllCategories() // Make sure method name matches
                Log.d("API_SUCCESS", "Received ${category.size} category")
                requireActivity().runOnUiThread {
                    recyclerView.adapter = CategoryAdapter(category)
                    recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Failed to load categories", e)
                requireActivity().runOnUiThread {
                    Toast.makeText(
                        requireContext(),
                        "Error: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        return view
    }
}