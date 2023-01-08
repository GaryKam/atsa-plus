package io.github.garykam.atsaplus.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NumberRow(range: IntRange, onClick: (Int) -> Unit) {
    Row {
        for (number in range) {
            Button(
                onClick = { onClick(number) },
                modifier = Modifier
                    .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
                    .padding(2.dp),
                shape = RoundedCornerShape(20F),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = number.toString())
            }
        }
    }
}