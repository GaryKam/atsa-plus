package io.github.garykam.atsaplus.ui.memorydifference

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.math.abs

data class GameState(
    val currentNumber: Int = -1,
    val correct: Int = 0
)

class MemoryDifferenceViewModel : ViewModel() {
    private var _currentNumber = MutableStateFlow(-1)
    private var _correct = MutableStateFlow(0)
    private val numberList = mutableListOf<Int>()
    private var previousNumber = mutableStateOf(-1)
    private var index = 0
    private var awaitingAnswer = false

    val gameState: StateFlow<GameState> =
        combine(_currentNumber, _correct) { currentNumber, correct ->
            GameState(currentNumber, correct)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), GameState())

    init {
        var num = (1..9).random()
        repeat(20) {
            (1..9).randomButExclude(num).let {
                numberList.add(it)
                num = it
            }
        }

        _currentNumber.value = numberList[0]

        viewModelScope.launch {
            delay(3000L)
            updateNumber()
        }
    }

    fun checkAnswer(answer: Int) {
        if (awaitingAnswer) {
            if (answer == abs(previousNumber.value - _currentNumber.value)) {
                _correct.value++
            }

            updateNumber()
        }
    }

    private fun updateNumber() {
        previousNumber.value = _currentNumber.value
        _currentNumber.value = numberList[++index]
        awaitingAnswer = true
    }
}

private fun IntRange.randomButExclude(exclude: Int): Int {
    val random = random()
    return if (random != exclude) random else randomButExclude(exclude)
}