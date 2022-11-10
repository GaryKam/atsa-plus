package io.github.garykam.atsaplus

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.schedule
import kotlin.math.abs

class MemoryGameViewModel : ViewModel() {
    private var gameStarted = mutableStateOf(false)
    private val numberList: MutableList<Int> = mutableListOf()
    private var previousNumber = mutableStateOf(-1)
    private var currentNumber = mutableStateOf(-1)
    private var correct = mutableStateOf(0)
    private var index: Int = 0

    init {
        var num = (1..9).random()
        repeat(20) {
            (1..9).randomButExclude(num).let {
                numberList.add(it)
                num = it
            }
        }
    }

    fun startGame() {
        gameStarted.value = true
        currentNumber.value = numberList[0]

        Timer().schedule(2000) {
            updateNumber()
        }
    }

    fun checkAnswer(answer: Int) {
        if (answer == abs(previousNumber.value - currentNumber.value)) {
            correct.value++
        }

        updateNumber()
    }

    private fun updateNumber() {
        previousNumber.value = currentNumber.value
        currentNumber.value = numberList[++index]
    }

    fun hasGameStarted() = gameStarted.value

    fun getCurrentNumber() = currentNumber.value

    fun getCorrect() = correct.value
}