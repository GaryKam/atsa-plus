package io.github.garykam.atsaplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import io.github.garykam.atsaplus.games.memorydifference.MemoryDifferenceGame
import io.github.garykam.atsaplus.games.memorydifference.MemoryDifferenceGameViewModel
import io.github.garykam.atsaplus.games.memoryvariable.MemoryVariableGame
import io.github.garykam.atsaplus.games.memoryvariable.MemoryVariableGameViewModel
import io.github.garykam.atsaplus.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    private val memoryDifferenceGameViewModel: MemoryDifferenceGameViewModel by viewModels()
    private val memoryVariableGameViewModel: MemoryVariableGameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AtsaPlusApp {
                /*MemoryDifferenceGame(
                    viewModel = gameViewModel,
                    onStart = { gameViewModel.startGame() },
                    onClick = { gameViewModel.checkAnswer(it) }
                )*/
                MemoryVariableGame(
                    viewModel = memoryVariableGameViewModel,
                    onStart = { memoryVariableGameViewModel.startGame() },
                    onClick = { memoryVariableGameViewModel.checkAnswer(it) }
                )
            }
        }
    }
}

@Composable
private fun AtsaPlusApp(content: @Composable () -> Unit) {
    AppTheme {
        content()
    }
}
