package io.github.garykam.atsaplus

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.abs

class MemoryGameViewModel : ViewModel() {
    private val numberList: MutableList<Int> = mutableListOf()
    private var number = mutableStateOf(-1)
    private var index: Int = 0
    private var correct = mutableStateOf(0)

    init {
        var num = (1..9).random()
        repeat(20) {
            (1..9).randomButExclude(num).let {
                numberList.add(it)
                num = it
            }
        }
    }

    fun nextNumber() {
        number.value = numberList[index++]
    }

    fun checkAnswer(answer: Int) {
        if (answer == abs(numberList[index - 2] - numberList[index - 1])) {
            correct.value++
        }
    }

    fun getNumber() = number.value

    fun getCorrect() = correct.value
}