package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class UserNumberGenerator(private val inputText: String) {
    init {
        val isNumbers = inputText.all { it.toString().matches(ONE_TO_NINE_REGEX.toRegex()) }
        val isDuplication = inputText.toMutableList().distinct().size == inputText.length
        require(!isNumbers || !isDuplication){ println()}
    }
    fun generate(): MutableList<Int> = inputText.map { it.digitToInt() }.toMutableList()

    companion object{
        const val ONE_TO_NINE_REGEX = "[1-9]"
    }
}