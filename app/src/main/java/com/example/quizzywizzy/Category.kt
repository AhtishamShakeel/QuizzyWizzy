package com.example.quizzywizzy

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String // Use @SerializedName if keys differ
)