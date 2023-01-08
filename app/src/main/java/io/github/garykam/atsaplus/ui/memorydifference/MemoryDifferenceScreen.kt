package io.github.garykam.atsaplus.ui.memorydifference

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.garykam.atsaplus.ui.components.NumberPad

@Composable
fun MemoryDifferenceScreen(viewModel: MemoryDifferenceViewModel = viewModel()) {
    val gameState by viewModel.gameState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Correct: ${gameState.correct}",
            modifier = Modifier.padding(bottom = 20.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = gameState.currentNumber.toString(),
            style = MaterialTheme.typography.displayLarge
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            NumberPad(onClick = { viewModel.checkAnswer(it) })
        }
    }
}