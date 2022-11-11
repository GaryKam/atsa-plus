package io.github.garykam.atsaplus.ui.memoryvariable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.garykam.atsaplus.utils.NumberRow

@Composable
fun MemoryVariableScreen(viewModel: MemoryVariableViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
                text = viewModel.getEquation(),
                style = MaterialTheme.typography.displayLarge
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                NumberRow((1..4)) { viewModel.checkAnswer(it) }
            }
        } else {
            Button(onClick = { viewModel.startGame() }) {
                Text(text = "Start")
            }
        }
    }
}