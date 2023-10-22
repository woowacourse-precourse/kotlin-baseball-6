package baseball.view

import camp.nextstep.edu.missionutils.Console

private const val MIN_VALUE = 100
private const val MAX_VALUE = 999

class ReadNumberView : ReadUserInputView() {

    override fun readUserInput(): Int {
        println("숫자 야구 게임을 시작합니다.")
        print("숫자를 입력해주세요 : ")
        val userInput = Console.readLine()
        validateNumberFormat(userInput)
        return userInput.toInt()
    }

    override fun validateNumberFormat(userInput: String) {
        require(isNumberFormat(userInput)) { "입력값은 숫자여야 합니다!" }
        val userNumber = userInput.toInt()
        require(isCorrectRangeNumber(userNumber)) { "세자리 숫자여야 합니다!" }
        require(isContainsZero(userNumber)) { "0은 사용되지 않는 숫자입니다!" }
    }


    override fun isCorrectRangeNumber(userNumber: Int): Boolean {
        return when (userNumber) {
            in MIN_VALUE..MAX_VALUE -> true
            else -> false
        }
    }

    private fun isContainsZero(userNumber: Int): Boolean {
        var currentNumber = userNumber
        val lastNumber = currentNumber % 10
        if (lastNumber == 0) return false
        currentNumber /= 10

        val middleNumber = currentNumber % 10
        if (middleNumber == 0) return false
        currentNumber /= 10

        return true
    }
}