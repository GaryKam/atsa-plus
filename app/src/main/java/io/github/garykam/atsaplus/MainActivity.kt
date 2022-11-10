package io.github.garykam.atsaplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import io.github.garykam.atsaplus.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    private val gameViewModel: MemoryGameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AtsaPlusApp {
                MemoryGame(
                    viewModel = gameViewModel,
                    onStart = { gameViewModel.startGame() },
                    onClick = { gameViewModel.checkAnswer(it) }
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
