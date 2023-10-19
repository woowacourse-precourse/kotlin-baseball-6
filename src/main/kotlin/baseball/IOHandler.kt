package baseball

import baseball.data.InputType
import camp.nextstep.edu.missionutils.Console

class IOHandler {

    private val validInputAfterGame = listOf("1", "2")
    private val validInputWhileGame = (1..10).map { (it + ASCII_0_CODE).toChar() }

    fun getInput(inputType: InputType): String {
        val input = Console.readLine()

        val isValid = when (inputType) {
            InputType.WHILE_GAME -> checkInputValidWhileGame(input)
            InputType.AFTER_GAME -> checkInputValidAfterGame(input)
        }
        if (isValid.not()) {
            throw IllegalArgumentException()
        }
        return input
    }

    fun show(msg: String) = print(msg)

    private fun checkInputValidWhileGame(input: String): Boolean {
        val inputNum = mutableSetOf<Char>()

        for (num in input) {
            if (num !in validInputWhileGame || inputNum.contains(num) || inputNum.size > 2) {
                return false
            }
            inputNum.add(num)
        }
        return true
    }

    private fun checkInputValidAfterGame(input: String) = input in validInputAfterGame

    companion object {
        private const val ASCII_0_CODE = 48
    }
}