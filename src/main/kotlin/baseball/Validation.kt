package baseball

import baseball.Constant.Companion.END
import baseball.Constant.Companion.MAX_BALL_NUMBER
import baseball.Constant.Companion.MIN_BALL_NUMBER
import baseball.Constant.Companion.RESTART

class Validation {

    fun checkBallNumbersValidity(numbersInput: String) {
        checkIsNumberCountThree(numbersInput)
        checkIsUniqueThreeNumber(numbersInput)
        checkIsNumber(numbersInput)
        checkHasCorrectNumRange(numbersInput)
    }

    fun checkPlayerDecisionValidity(userInput: String) {
        checkIsNumberCountOne(userInput)
        checkIsNumber(userInput)
        checkIsCorrectNumber(userInput)
    }

    private fun checkIsNumberCountOne(input: String) {
        require(input.length == 1) { "입력 숫자는 1자리 숫자여야 합니다." }
    }

    private fun checkIsNumberCountThree(input: String) {
        require(input.length == 3) { "입력 숫자는 3자리 숫자여야 합니다." }
    }

    private fun checkIsUniqueThreeNumber(input: String) {
        require(input.length == input.toSet().size) { "입력 숫자는 서로 다른 3자리 숫자여야 합니다." }
    }

    private fun checkIsNumber(input: String) {
        require(input.toIntOrNull() != null) { "숫자 이외의 값은 입력될 수 없습니다." }
    }

    private fun checkHasCorrectNumRange(input: String) {
        require(input.all { it.toString() in MIN_BALL_NUMBER..MAX_BALL_NUMBER }) { "1~9 이외의 숫자는 입력될 수 없습니다." }
    }

    private fun checkIsCorrectNumber(input: String) {
        require(input == RESTART || input == END) { "1과 2 이외의 숫자는 입력될 수 없습니다." }
    }
}