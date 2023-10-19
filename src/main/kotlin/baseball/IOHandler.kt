package baseball

import baseball.data.InputType
import camp.nextstep.edu.missionutils.Console

class IOHandler {

    private val validInputAfterGame = listOf("1", "2")
    private val validInputWhileGame = (1..10).map { (it + ASCII_0_CODE).toChar() }

    fun getInput(inputType: InputType): String {
        val input = Console.readLine()

        if (checkInputValid(input, inputType).not()) {
            throw IllegalArgumentException()
        }
        return input
    }

    fun show(msg: String) = print(msg)

    private fun checkInputValid(input: String, inputType: InputType): Boolean {
        return when (inputType) {
            InputType.WHILE_GAME -> checkInputValidWhileGame(input)
            InputType.AFTER_GAME -> checkInputValidAfterGame(input)
        }
    }

    private fun checkInputValidWhileGame(input: String): Boolean {
        return input.filter {
            it in validInputWhileGame
        }.toSet().size == 3
    }

    private fun checkInputValidAfterGame(input: String) = input in validInputAfterGame

    companion object {
        private const val ASCII_0_CODE = 48
    }
}