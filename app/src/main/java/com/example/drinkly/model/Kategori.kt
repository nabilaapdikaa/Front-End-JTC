package com.example.drinkly.model

import androidx.compose.ui.graphics.Color

data class Kategori(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
    val recipeIds: List<Int> = emptyList(),
    val tags: List<String> = emptyList(),
    val themeColor: Color = Color.Unspecified
)

