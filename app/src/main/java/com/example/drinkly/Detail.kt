package com.example.drinkly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drinkly.viewmodel.CategoryHeader
import com.example.drinkly.viewmodel.DateDetail
import com.example.drinkly.viewmodel.RecipeRow
import com.example.drinkly.viewmodel.RecommendationDetail
import com.example.drinkly.data.DummyData.kategoriList
import com.example.drinkly.data.DummyData.rekomendasiList
import com.example.drinkly.data.DummyData.tanggalList
import com.example.drinkly.model.DetailContent
import com.example.drinkly.model.Tanggal
import com.example.drinkly.ui.theme.Background
import com.example.drinkly.ui.theme.DrinklyTheme
import com.example.drinkly.ui.theme.Primary
import com.example.drinkly.ui.theme.TextSecondary

@Composable
fun DetailScreen(
    id: Int,
    itemType: String,
    onNavigateToRecommendation: (Int) -> Unit
) {
    fun updateDate(updatedDate: Tanggal) {
        val index = tanggalList.indexOfFirst { it.id == updatedDate.id }
        if (index != -1) {
            tanggalList[index] = updatedDate
        }
    }

    val content: DetailContent? = when (itemType) {
        "recommendation" -> rekomendasiList.find { it.id == id }?.let { DetailContent.Recommendation(it) }
        "date" -> tanggalList.find { it.id == id }?.let { DetailContent.Date(it) }
        "category" -> kategoriList.find { it.id == id }?.let { DetailContent.Category(it) }
        else -> null
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Background),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = when (itemType) {
                    "recommendation" -> "Detail Rekomendasi"
                    "date" -> "Detail Tanggal"
                    "category" -> "Detail Kategori"
                    else -> "Detail"
                },
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Primary,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        item {
            content?.let {
                when (it) {
                    is DetailContent.Recommendation -> RecommendationDetail(it.data)
                    is DetailContent.Date -> {
                        DateDetail(
                            data = it.data,
                            onSave = { updatedDate ->
                                updateDate(updatedDate)
                            }
                        )
                    }
                    is DetailContent.Category -> {
                        CategoryHeader(it.data)
                    }
                }
            } ?: run {
                Text(
                    text = "Data tidak ditemukan",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        if (itemType == "category") {
            val category = kategoriList.find { it.id == id }
            category?.let {
                item {
                    Text(
                        text = "Rekomendasi",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Primary,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(rekomendasiList.filter { recipe -> recipe.id in it.recipeIds }) { recipe ->
                    RecipeRow(recipe = recipe, onClick = onNavigateToRecommendation)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    DrinklyTheme {
        DetailScreen(
            id = 1,
            itemType = "Recommendation",
            onNavigateToRecommendation = {}
        )
    }
}
