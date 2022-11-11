package io.github.garykam.atsaplus.games.memoryvariable

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MemoryVariableGameViewModel : ViewModel() {
    private var gameStarted = mutableStateOf(false)
    private var equation = mutableStateOf("")
    private var a = -1
    private var b = -1
    private var c = -1
    private var correct = mutableStateOf(0)
    private var awaitingAnswer = false

    fun startGame() {
        gameStarted.value = true
        updateEquation()
    }

    fun checkAnswer(answer: Int) {
        if (awaitingAnswer) {
            awaitingAnswer = false

            when (equation.value) {
                "A =" -> a
                "B =" -> b
                "C =" -> c
                else -> -1
            }.also {
                if (answer == it) {
                    correct.value++
                }
            }

            promptForAnswer()
        }
    }

    private fun updateEquation() {
        a = (1..4).random()
        b = (1..4).random()
        c = (1..4).random()

        viewModelScope.launch {
            delay(1000L)
            equation.value = "A = $a"
            delay(2000L)
            equation.value = ""
            delay(1000L)
            equation.value = "B = $b"
            delay(2000L)
            equation.value = ""
            delay(1000L)
            equation.value = "C = $c"
            delay(2000L)
            equation.value = ""
            delay(2000L)

            promptForAnswer()
        }
    }

    private fun promptForAnswer() {
        viewModelScope.launch {
            when (equation.value) {
                "" -> "A ="
                "A =" -> "B ="
                "B =" -> "C ="
                else -> ""
            }.also {
                equation.value = it
            }

            awaitingAnswer = true
        }
    }

    fun hasGameStarted() = gameStarted.value

    fun getEquation() = equation.value

    fun getCorrect() = correct.value
}