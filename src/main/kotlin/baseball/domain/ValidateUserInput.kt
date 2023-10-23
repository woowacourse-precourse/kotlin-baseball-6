package baseball.domain

private const val RESTART_GAME = 1
private const val EXIT_GAME = 2
private const val MIN_VALUE = 100
private const val MAX_VALUE = 999

class ValidateUserInput {

    fun validateNumber(userInput: String): Int {
        require(isNumberFormat(userInput)) { "입력값은 숫자여야 합니다!" }
        val userNumber = userInput.toInt()
        require(isCorrectRangeNumber(userNumber)) { "세자리 숫자여야 합니다!" }
        require(isContainsZero(userNumber)) { "0은 사용되지 않는 숫자입니다!" }
        return userNumber

    }

    fun validateRestart(userInput: String): ChoiceState {
        require(isNumberFormat(userInput)) { "입력값은 숫자여야 합니다!" }
        val userChoice = userInput.toInt()
        require(isCorrectRangeChoice(userChoice)) { "1 또는 2를 입력해주세요!" }
        return when (userChoice) {
            RESTART_GAME -> ChoiceState.Restart
            EXIT_GAME -> ChoiceState.Exit
            else -> {
                require(true) { "1 또는 2를 입력해주세요!" }
                ChoiceState.Exit
            }
        }
    }

    private fun isNumberFormat(userChoice: String): Boolean {
        return userChoice.all { char -> char.isDigit() }
    }

    private fun isCorrectRangeChoice(userNumber: Int): Boolean {
        return when (userNumber) {
            in RESTART_GAME..EXIT_GAME -> true

            else -> false
        }
    }

    private fun isCorrectRangeNumber(userNumber: Int): Boolean {
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