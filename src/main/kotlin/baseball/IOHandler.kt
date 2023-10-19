package baseball

import baseball.data.InputType
import camp.nextstep.edu.missionutils.Console

class IOHandler {

    private val validInputAfterGame = listOf("1", "2")
    private val validInputWhileGame = (1..10).map { (it + ASCII_0_CODE).toChar() }

    fun getInput(inputType: InputType): String {
        val input = Console.readLine()

        when (inputType) {
            InputType.WHILE_GAME -> checkInputValidWhileGame(input)
            InputType.AFTER_GAME -> checkInputValidAfterGame(input)
        }

        return input
    }

    fun show(msg: String) = print(msg)

    private fun checkInputValidWhileGame(input: String) {
        val inputNum = mutableSetOf<Char>()

        input.forEach {
            if (it !in validInputWhileGame || inputNum.contains(it) || inputNum.size > 2) {
                throw IllegalArgumentException()
            }
            inputNum.add(it)
        }
    }

    private fun checkInputValidAfterGame(input: String) {
        if (input in validInputAfterGame) {
            return
        }
        throw IllegalArgumentException()
    }

    companion object {
        private const val ASCII_0_CODE = 48
    }
}