package io.github.garykam.atsaplus.ui.memorydifference

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.garykam.atsaplus.utils.NumberPad

@Composable
fun MemoryDifferenceScreen(onBack: () -> Unit, viewModel: MemoryDifferenceViewModel = viewModel()) {
    SmallTopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val gameState by viewModel.gameState.collectAsState()

        if (gameState.gameStarted) {
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
                NumberPad { viewModel.checkAnswer(it) }
            }
        } else {
            Button(onClick = { viewModel.startGame() }) {
                Text(text = "Start")
            }
        }
    }
}