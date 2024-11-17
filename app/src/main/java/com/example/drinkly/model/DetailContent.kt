package com.example.drinkly.model

sealed class DetailContent {
    data class Recommendation(val data: Rekomendasi) : DetailContent()
    data class Date(val data: Tanggal) : DetailContent()
    data class Category(val data: Kategori) : DetailContent()
}
