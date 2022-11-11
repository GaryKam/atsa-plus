package io.github.garykam.atsaplus.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun NumberPad(onClick: (Int) -> Unit) {
    Column {
        NumberRow(range = (1..3), onClick)
        NumberRow(range = (4..6), onClick)
        NumberRow(range = (7..9), onClick)
    }
}