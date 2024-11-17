package com.example.drinkly.viewmodel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drinkly.R
import com.example.drinkly.model.Tanggal
import com.example.drinkly.ui.theme.Primary
import com.example.drinkly.ui.theme.TextSecondary

@Composable
fun DateDetail(
    data: Tanggal,
    onSave: (Tanggal) -> Unit
) {
    var notes by remember { mutableStateOf(data.notes) }
    var waterConsumed by remember { mutableStateOf(data.waterConsumed.toString()) }
    var targetWater by remember { mutableStateOf(data.targetWater.toString()) }
    var isEditing by remember { mutableStateOf(false) }
    var isSaved by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Tanggal: ${data.date} (${data.day})",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Primary
        )

        Spacer(modifier = Modifier.height(8.dp))
        if (isEditing) {
            TextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Catatan") }
            )
        } else {
            Text(
                text = "Catatan: $notes",
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        if (isEditing) {
            TextField(
                value = waterConsumed,
                onValueChange = { waterConsumed = it },
                label = { Text("Air Diminum (ml)") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        } else {
            Text(
                text = "Air Diminum: $waterConsumed ml",
                style = MaterialTheme.typography.bodyMedium,
                color = Primary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        if (isEditing) {
            TextField(
                value = targetWater,
                onValueChange = { targetWater = it },
                label = { Text("Target Air (ml)") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        } else {
            Text(
                text = "Target Air: $targetWater ml",
                style = MaterialTheme.typography.bodyMedium,
                color = Primary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (isEditing) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        onSave(
                            data.copy(
                                notes = notes,
                                waterConsumed = waterConsumed.toIntOrNull() ?: data.waterConsumed,
                                targetWater = targetWater.toIntOrNull() ?: data.targetWater
                            )
                        )
                        isEditing = false
                        isSaved = true
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_save),
                        contentDescription = "Simpan",
                        tint = Primary,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Simpan",
                        color = Primary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { isEditing = false }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cancel),
                        contentDescription = "Batal",
                        tint = Color.Red,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Batal",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            } else {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { isEditing = true }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "Edit",
                        tint = Primary,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Edit",
                        color = Primary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (isSaved) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Sukses",
                    tint = Primary,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Yeah, Data berhasil disimpan!",
                    color = Primary,
                    fontSize = 14.sp
                )
            }
        }
    }
}









