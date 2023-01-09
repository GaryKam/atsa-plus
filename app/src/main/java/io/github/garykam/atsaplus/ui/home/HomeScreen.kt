package io.github.garykam.atsaplus.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onClickMemoryDifference: () -> Unit,
    onClickMemoryVariable: () -> Unit,
    onClickSpatialRelationship: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select a Game", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = onClickMemoryDifference) {
            Text(text = "Difference Memorization")
        }

        Button(onClick = onClickMemoryVariable) {
            Text(text = "Variable Memorization")
        }

        Button(onClick = onClickSpatialRelationship) {
            Text(text = "Spatial Relationship")
        }
    }
}