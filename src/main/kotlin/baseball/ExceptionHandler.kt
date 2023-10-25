package baseball

import baseball.Constant.FINISH_BASEBALL_GAME_MESSAGE
import baseball.Constant.LENGTH_EXCEPTION_MESSAGE
import baseball.Constant.NO_DIGIT_EXCEPTION_MESSAGE
import baseball.Constant.NUMBER_DUPLICATED_EXCEPTION_MESSAGE
import baseball.Constant.NUMBER_LENGTH
import baseball.Constant.WRONG_INPUT_EXCEPTION_MESSAGE

object ExceptionHandler {

    fun checkPlayerInput(number: String) {
        checkPlayerInputIsNumber(number)
        checkPlayerInputIsThree(number)
        checkPlayerInputIsDifferent(number)
    }

    private fun checkPlayerInputIsNumber(number: String) {
        number.forEach {
            if (!it.isDigit()) {
                throw IllegalArgumentException(NO_DIGIT_EXCEPTION_MESSAGE)
            }
        }
    }

    private fun checkPlayerInputIsThree(number: String) {
        if (number.length != NUMBER_LENGTH) {
            throw IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE)
        }
    }

    private fun checkPlayerInputIsDifferent(number: String) {
        val numberSet = number.toSet()
        if (numberSet.size != NUMBER_LENGTH) {
            throw IllegalArgumentException(NUMBER_DUPLICATED_EXCEPTION_MESSAGE)
        }
    }

    fun checkPlayerInputIsRestartOrFinish(playerInput: Int) {
        when (playerInput) {
            1 -> Game.reStart()
            2 -> println(FINISH_BASEBALL_GAME_MESSAGE)
            else -> throw IllegalArgumentException(WRONG_INPUT_EXCEPTION_MESSAGE)
        }
    }
}