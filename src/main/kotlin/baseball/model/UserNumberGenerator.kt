package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class UserNumberGenerator(private val inputText: String) : NumbersGenerator {
    init {
        val isNumbers = inputText.all { it.toString().matches(ONE_TO_NINE_REGEX.toRegex()) }
        val isDuplication = inputText.toMutableList().distinct().size == inputText.length
        require(!isNumbers || !isDuplication){ println()}
    }
    override fun generate(): MutableList<Int> = inputText.map { it.digitToInt() }.toMutableList()

    companion object{
        const val ONE_TO_NINE_REGEX = "[1-9]"
    }
}