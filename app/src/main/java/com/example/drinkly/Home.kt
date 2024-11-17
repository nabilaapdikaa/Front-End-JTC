package com.example.drinkly

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drinkly.data.DummyData
import com.example.drinkly.model.Rekomendasi
import com.example.drinkly.model.Tanggal
import com.example.drinkly.ui.theme.Background
import com.example.drinkly.ui.theme.DrinklyTheme
import com.example.drinkly.ui.theme.Primary
import com.example.drinkly.ui.theme.PrimaryDark
import com.example.drinkly.ui.theme.Surface
import com.example.drinkly.ui.theme.TextPrimary
import com.example.drinkly.ui.theme.TextSecondary
import com.example.drinkly.ui.theme.component.SearchBar

@Composable
fun HomeScreen(
    onDateClick: (Tanggal) -> Unit,
    onRecommendationClick: (Rekomendasi) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredRecommendations = DummyData.rekomendasiList.filter {
        it.title.contains(searchQuery, ignoreCase = true) ||
                it.description.contains(searchQuery, ignoreCase = true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {
        Text(
            text = "Drinkly",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = Primary
        )
        Text(
            text = "Nikmati setiap tegukan untuk tubuh yang lebih segar.",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(20.dp))
        SearchBar(
            searchQuery = searchQuery,
            onQueryChanged = { query -> searchQuery = query }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Pilih tanggal, pantau kemajuan Anda!",
            fontWeight = FontWeight.Bold,
            color = PrimaryDark
        )

        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(DummyData.tanggalList) { tanggal ->
                DateCard(tanggal = tanggal, onClick = { onDateClick(tanggal) })
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Rekomendasi Infused Water",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = PrimaryDark
        )

        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(filteredRecommendations) { rekomendasi ->
                RecommendationCard(rekomendasi = rekomendasi, onClick = { onRecommendationClick(rekomendasi) })
            }
        }
    }
}

@Composable
private fun DateCard(tanggal: Tanggal, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Primary),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = tanggal.day,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = tanggal.date,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
private fun RecommendationCard(rekomendasi: Rekomendasi, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Surface),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = rekomendasi.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 12.dp, horizontal = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = rekomendasi.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                 Text(
                    text = rekomendasi.description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    color = TextSecondary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DrinklyTheme {
        HomeScreen(
            onDateClick = {},
            onRecommendationClick = {}
        )
    }
}
