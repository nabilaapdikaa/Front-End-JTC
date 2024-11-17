package com.example.drinkly

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drinkly.ui.theme.Background
import com.example.drinkly.ui.theme.DrinklyTheme
import com.example.drinkly.ui.theme.Primary
import com.example.drinkly.ui.theme.PrimaryDark
import com.example.drinkly.ui.theme.TextSecondary

@Composable
fun ProfileScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(4.dp, Primary, CircleShape)
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Nabila Apdika",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Primary
        )
        Text(
            text = "nabilaapdikaa@gmail.com",
            fontSize = 14.sp,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(20.dp))
        ProfileInfoCard()

        Spacer(modifier = Modifier.height(16.dp))
        FavoriteCard(
            title = "Minuman Favorit",
            items = listOf("Lemon Mint Water", "Orange Cinnamon Water", "Blueberry Lime Water")
        )

        Spacer(modifier = Modifier.height(16.dp))
        HidrationGoalCard()
    }
}

@Composable
fun ProfileInfoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Background)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ProfileInfoItem(title = "Perguruan Tinggi", value = "Universitas Lampung")
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 8.dp),
            )
            ProfileInfoItem(title = "Jurusan", value = "Teknik Informatika")
        }
    }
}

@Composable
fun HidrationGoalCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Background)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Target Hidrasi Saya",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryDark
            )
            Spacer(modifier = Modifier.height(16.dp))
            HidrationGoalProgress(current = 1700, goal = 2000)
        }
    }
}

@Composable
fun FavoriteCard(title: String, items: List<String>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Background)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            items.forEach { item ->
                Text(
                    text = "• $item",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun ProfileInfoItem(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Primary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
    }
}

@Composable
fun HidrationGoalProgress(current: Int, goal: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        LinearProgressIndicator(
            progress = { current.toFloat() / goal.toFloat() },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp)),
            color = Primary,
            trackColor = Background,
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$current mL / $goal mL",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    DrinklyTheme {
        ProfileScreen()
    }
}