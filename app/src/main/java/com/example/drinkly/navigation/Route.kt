package com.example.drinkly.navigation

object Route {
    const val HOME = "home"
    const val KATEGORI = "kategori"
    const val PROFILE = "profile"
    const val DETAIL = "detail/{itemType}/{itemId}"
    fun detailRoute(itemType: String, itemId: Int) = "detail/$itemType/$itemId"
}
