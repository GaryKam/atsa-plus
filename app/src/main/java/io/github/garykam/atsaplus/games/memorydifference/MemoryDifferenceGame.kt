package io.github.garykam.atsaplus.games.memorydifference

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.garykam.atsaplus.utils.NumberPad

@Composable
fun MemoryDifferenceGame(
    viewModel: MemoryDifferenceGameViewModel,
    onStart: () -> Unit,
    onClick: (Int) -> Unit
) {
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