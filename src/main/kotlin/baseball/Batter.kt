package baseball

import camp.nextstep.edu.missionutils.Console

class Batter(
    private val numberCount: Int,
    private val minNumber: Int,
    private val maxNumber: Int
) {
    private var numbers = listOf<Int>()
    private val validator = Validator()

    fun enterNumbers(): List<Int> {
        val numbers = mutableListOf<Int>()
        val userInput = enteredInput()

        formatChangedNumbers(userInput).map { number -> numbers.add(number) }

        return numbers
    }

    private fun enteredInput(): String {
        val message = "숫자를 입력해주세요 : "

        print(message)
        return Console.readLine()
    }

    private fun formatChangedNumbers(input: String): List<Int> {
        validateNumbers(input)
        return input.map { data -> Character.getNumericValue(data) }
    }

    private fun validateNumbers(input: String) {
        validator.checkNumberCount(input, numberCount)
        validator.checkNumberFormat(input)
        validator.checkNumberRange(input, minNumber, maxNumber)
    }
}