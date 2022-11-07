package io.github.garykam.atsaplus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*
import kotlin.concurrent.schedule

@Composable
fun MemoryGame(viewModel: MemoryGameViewModel) {
    var hasStarted by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (hasStarted) {
                Text(
                    text = "Correct: ${viewModel.getCorrect()}",
                    modifier = Modifier.padding(bottom = 20.dp),
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = viewModel.getNumber().toString(),
                    style = MaterialTheme.typography.displayLarge
                )
            } else {
                Button(onClick = {
                    hasStarted = true
                    viewModel.nextNumber()

                    Timer().schedule(2000) {
                        viewModel.nextNumber()
                    }
                }) {
                    Text(text = "Start")
                }
            }
        }

        if (hasStarted) {
            Column(
                modifier = Modifier.padding(bottom = 40.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NumberPad(viewModel)
            }
        }
    }
}

@Composable
private fun NumberPad(viewModel: MemoryGameViewModel) {
    NumberInput(range = (1..3), viewModel)
    NumberInput(range = (4..6), viewModel)
    NumberInput(range = (7..9), viewModel)
}

@Composable
private fun NumberInput(range: IntRange, viewModel: MemoryGameViewModel) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in range) {
            Button(onClick = {
                viewModel.checkAnswer(i)
                viewModel.nextNumber()
            }) {
                Text(text = i.toString())
            }
        }
    }
}