package com.example.drinkly.model

data class Rekomendasi(
    val id: Int,
    val title: String,
    val description: String,
    val imageRes: Int,
    val ingredients: List<String>,
    val benefits: String,
    val preparationSteps: List<String>
)
