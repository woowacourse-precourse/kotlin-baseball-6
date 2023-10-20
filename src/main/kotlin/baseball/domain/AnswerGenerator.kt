package baseball.domain

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class AnswerGenerator {
    fun generate(): List<Int> {
        val answer: MutableSet<Int> = HashSet()
        while (answer.size < 3) {
            val randomNum = pickNumberInRange(1, 9)
            answer.add(randomNum)
        }
        return answer.toList()
    }
}