package io.github.garykam.atsaplus.ui.memoryvariable

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MemoryVariableViewModel : ViewModel() {
    private var gameStarted = mutableStateOf(false)
    private var variable = Variable.NONE
    private var equation = mutableStateOf("")
    private var correct = mutableStateOf(0)
    private var awaitingAnswer = false

    fun startGame() {
        gameStarted.value = true
        updateEquation()
    }

    fun checkAnswer(answer: Int) {
        if (awaitingAnswer) {
            awaitingAnswer = false

            if (answer == variable.value) {
                correct.value++
            }

            promptForAnswer()
        }
    }

    private fun updateEquation() {
        Variable.A.randomize()
        Variable.B.randomize()
        Variable.C.randomize()

        viewModelScope.launch {
            updateEquationVariable(Variable.A)
            updateEquationVariable(Variable.B)
            updateEquationVariable(Variable.C)
            delay(2000L)

            variable = Variable.NONE
            promptForAnswer()
        }
    }

    private suspend fun updateEquationVariable(variable: Variable) {
        delay(1000L)
        equation.value = variable.name + " = " + variable.value
        delay(2000L)
        equation.value = ""
    }

    private fun promptForAnswer() {
        variable = when (variable) {
            Variable.NONE -> Variable.A
            Variable.A -> Variable.B
            Variable.B -> Variable.C
            Variable.C -> {
                equation.value = ""
                updateEquation()
                return
            }
        }

        viewModelScope.launch {
            equation.value = variable.name + " ="
            awaitingAnswer = true
        }
    }

    fun hasGameStarted() = gameStarted.value

    fun getEquation() = equation.value

    fun getCorrect() = correct.value

    private enum class Variable(var value: Int = -1) {
        A,
        B,
        C,
        NONE;

        fun randomize() {
            value = (1..4).random()
        }
    }
}