package io.github.garykam.atsaplus.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NumberRow(range: IntRange, onClick: (Int) -> Unit) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        for (number in range) {
            Button(onClick = { onClick(number) }) {
                Text(text = number.toString())
            }
        }
    }
}