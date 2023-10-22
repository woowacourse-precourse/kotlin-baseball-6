package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

private const val START = 1
private const val END = 9
private const val LENGTH = 3

fun main() {

}

private fun generateRandomNumberList(): List<Int> {
    val numberSet = mutableSetOf<Int>()

    while (numberSet.size < LENGTH) {
        numberSet.add(pickNumberInRange(START, END))
    }
    return numberSet.toList()
}

private fun checkUserInput(userInput: String): List<Int> {
    try {
        validateUserLength(userInput)
        validateUserInRange(userInput)
        return userInput.map { it.toString().toInt() }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자가 아닙니다.")
    } catch (e: IllegalArgumentException) {
        throw e
    }
}

private fun validateUserInRange(userInput: String) {
    userInput.forEach { number ->
        if (number.toString().toInt() < START || number.toString().toInt() > END) {
            throw IllegalArgumentException("범위에 속하지 않은 숫자입니다.")
        }
    }
}

private fun validateUserLength(userInput: String) {
    if (userInput.length != LENGTH) {
        throw IllegalArgumentException("세 자리가 아닙니다.")
    }
}