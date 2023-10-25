package baseball.model

import baseball.config.GameNumberConfig.DIGIT_NUMBER
import baseball.config.GameNumberConfig.END_INCLUSIVE
import baseball.config.GameNumberConfig.START_INCLUSIVE
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    var input: String = ""
    private var answer: List<Int> = emptyList()

    private val numberComparator = NumberComparator()

    fun generateAnswer() {
        val answer = mutableListOf<Int>()
        while (answer.size < DIGIT_NUMBER) {
            val randomNum = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)
            if (!answer.contains(randomNum)) {
                answer.add(randomNum)
            }
        }
        this.answer = answer.toList()
    }

    fun getResult(): BallAndStrike {
        return numberComparator.compare(input, answer)
    }
}