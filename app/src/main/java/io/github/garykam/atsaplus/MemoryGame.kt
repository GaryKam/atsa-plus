package io.github.garykam.atsaplus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MemoryGame(viewModel: MemoryGameViewModel, onStart: () -> Unit, onClick: (Int) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (viewModel.hasGameStarted()) {
                Text(
                    text = "Correct: ${viewModel.getCorrect()}",
                    modifier = Modifier.padding(bottom = 20.dp),
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = viewModel.getCurrentNumber().toString(),
                    style = MaterialTheme.typography.displayLarge
                )
            } else {
                Button(onClick = onStart) {
                    Text(text = "Start")
                }
            }
        }

        if (viewModel.hasGameStarted()) {
            Column(
                modifier = Modifier.padding(bottom = 40.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NumberPad(onClick)
            }
        }
    }
}

@Composable
private fun NumberPad(onClick: (Int) -> Unit) {
    NumberInput(range = (1..3), onClick)
    NumberInput(range = (4..6), onClick)
    NumberInput(range = (7..9), onClick)
}

@Composable
private fun NumberInput(range: IntRange, onClick: (Int) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (number in range) {
            Button(onClick = { onClick(number) }) {
                Text(text = number.toString())
            }
        }
    }
}