package baseball

import baseball.GameManager.ExitCode.ONE
import baseball.GameManager.ExitCode.TWO
import camp.nextstep.edu.missionutils.Console

class InputManager {
    companion object ErrorMessage {
        const val NULL: String = "빈 값 입니다."
        const val CONTAIN_ZERO = "0은 포함될 수 없습니다."
        const val DUPLICATE = "중복된 숫자는 입력할 수 없습니다."
        const val OUT_OF_RANGE = "입력 범위를 초과하였습니다."
    }

    fun input(command: String, digit: Digit): Int {
        print(command)
        val input = Console.readLine() ?: throw IllegalArgumentException(NULL)
        when(digit) {
            Digit.ONE -> checkSingleDigitInput(input)
            Digit.THREE -> checkThreeDigitInput(input)
        }
        return input.toInt()
    }

    fun checkThreeDigitInput(input: String) {
        if(!isThreeDigitNumber(input)) { throw IllegalArgumentException(OUT_OF_RANGE) }
        if(isContainZero(input)) { throw IllegalArgumentException(CONTAIN_ZERO) }
        if(isDuplicate(input)) { throw IllegalArgumentException(DUPLICATE) }
    }
    private fun isThreeDigitNumber(input: String): Boolean = input.length == 3
    private fun isContainZero(input: String): Boolean = input.contains('0')
    private fun isDuplicate(input: String): Boolean = input.toSet().size != 3

    private fun checkSingleDigitInput(input: String) {
        val exitCode = input.toInt()
        if (exitCode != ONE && exitCode != TWO) { throw IllegalArgumentException(OUT_OF_RANGE) }
    }
}