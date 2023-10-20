package baseball.domain

import baseball.config.GameNumberConfig.DIGIT_NUMBER
import baseball.config.GameNumberConfig.END_INCLUSIVE
import baseball.config.GameNumberConfig.START_INCLUSIVE
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class AnswerGenerator {
    fun generate(): List<Int> {
        val answer: MutableSet<Int> = HashSet()
        while (answer.size < DIGIT_NUMBER) {
            val randomNum = pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)
            answer.add(randomNum)
        }
        return answer.toList()
    }
}