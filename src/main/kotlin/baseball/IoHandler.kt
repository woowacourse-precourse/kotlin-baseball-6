package baseball

import baseball.data.InputType
import camp.nextstep.edu.missionutils.Console

class IoHandler {

    private val validInputAfterGame = listOf("1", "2")

    fun getInput(inputType: InputType): String {
        val input = Console.readLine()

        when (inputType) {
            InputType.WHILE_GAME -> checkValidWhileGame(input)
            InputType.AFTER_GAME -> checkValidAfterGame(input)
        }

        return input
    }

    fun show(msg: String) {
        print(msg)
    }

    private fun checkValidWhileGame(input: String) {
        val inputNum = mutableSetOf<Char>()

        input.forEach {
            if (it.isDigit().not() || inputNum.contains(it) || inputNum.size > 2) {
                throw IllegalArgumentException()
            }
            inputNum.add(it)
        }
    }

    private fun checkValidAfterGame(input: String) {
        if (input in validInputAfterGame) {
            return
        }
        throw IllegalArgumentException()
    }
}