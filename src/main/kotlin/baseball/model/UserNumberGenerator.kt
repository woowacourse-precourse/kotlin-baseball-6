package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class UserNumberGenerator(inputText: String) {
    init {
        val isNumbers = inputText.all { it.toString().matches(ONE_TO_NINE_REGEX.toRegex()) }
        val isDuplication = inputText.toMutableList().distinct().size == inputText.length
        require(!isNumbers || !isDuplication){ println()}
    }
    fun generate(inputText:String): MutableList<Int> = inputText.map { it.digitToInt() }.toMutableList()

    companion object{
        const val ONE_TO_NINE_REGEX = "[1-9]"
    }
}