package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class UserNumbersGenerator(private val inputText: String) : NumbersGenerator {
    init {
        val isNumbers = inputText.all { it.toString().matches(ONE_TO_NINE_REGEX.toRegex()) }
        val isDuplication = inputText.toMutableList().distinct().size == inputText.length
        val isCorrectCount = inputText.length == USER_NUMBER_COUNT
        require(isNumbers && isDuplication && isCorrectCount) { println() }
    }

    override fun generate(): MutableList<Int> = inputText.map { it.digitToInt() }.toMutableList()

    companion object {
        const val ONE_TO_NINE_REGEX = "[1-9]"
        const val USER_NUMBER_COUNT = 3
    }
}