package baseball

private const val USER_ANSWER_OUT_OF_RANGE_ERROR_MESSAGE = "1 또는 2를 입력해야 합니다."
private const val USER_NUMBER_IS_NOT_NUMERIC_FORMATTED_ERROR_MESSAGE = "숫자가 아닌 다른 형식을 입력할 수 없습니다."
private const val USER_NUMBER_IS_INVALID_LENGTH_ERROR_MESSAGE = "3개의 숫자를 입력해야 합니다."
private const val USER_NUMBER_IS_DUPLICATED_ERROR_MESSAGE = "중복된 숫자를 입력할 수 없습니다."

fun validateUserNumbers(userInput: String) {
    if (!isNumericFormatted(userInput)) {
        throw IllegalArgumentException(USER_NUMBER_IS_NOT_NUMERIC_FORMATTED_ERROR_MESSAGE)
    }
    if (!isCorrectNumberOfDigits(userInput)) {
        throw IllegalArgumentException(USER_NUMBER_IS_INVALID_LENGTH_ERROR_MESSAGE)
    }
    if (!hasDuplicateDigits(userInput)) {
        throw IllegalArgumentException(USER_NUMBER_IS_DUPLICATED_ERROR_MESSAGE)
    }
}

fun validateUserAnswer(userInput: String) {
    if (!(userInput == "1" || userInput == "2")) {
        throw IllegalArgumentException(USER_ANSWER_OUT_OF_RANGE_ERROR_MESSAGE)
    }
}

private fun isNumericFormatted(userInput: String): Boolean {
    return userInput.all { it.isDigit() }
}

private fun isCorrectNumberOfDigits(userInput: String): Boolean {
    return (userInput.length == 3)
}

private fun hasDuplicateDigits(userInput: String): Boolean {
    return (userInput.toSet().size == 3)
}