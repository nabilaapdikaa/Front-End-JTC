package com.example.drinkly.model

data class Tanggal(
    val id: Int,
    val date: String,
    val day: String,
    val notes: String,
    val waterConsumed: Int,
    val targetWater: Int,
    val activities: List<String>
)
