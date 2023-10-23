package baseball.view

import camp.nextstep.edu.missionutils.Console

private const val RESTART_GAME = 1
private const val EXIT_GAME = 2

class ReadUserRestartChoiceView : ReadUserInputView() {

    override fun readUserInput(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput = Console.readLine()
        validateNumberFormat(userInput)
        return userInput.toInt()
    }

    override fun validateNumberFormat(userInput: String) {
        require(isNumberFormat(userInput)) { "입력값은 숫자여야 합니다.!" }
        val userChoice = userInput.toInt()
        isCorrectRangeNumber(userChoice)
    }

    override fun isCorrectRangeNumber(userNumber: Int): Boolean {
        return when (userNumber) {
            in RESTART_GAME..EXIT_GAME -> {
                true
            }

            else -> {
                false
            }
        }
    }
}