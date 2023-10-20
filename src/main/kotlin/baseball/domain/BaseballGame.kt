package baseball.domain

import baseball.model.Score
import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {

    fun generateRandomNumber(): String {
        val uniqueNumbers = mutableSetOf<Int>()
        while (uniqueNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            uniqueNumbers.add(randomNumber)
        }
        return uniqueNumbers.joinToString("")
    }

    fun calculateScore(answer: String, userAnswer: String): Score {
        val score = Score(0, 0, 0)

        answer.forEachIndexed { index, c ->
            when {
                c == userAnswer[index] -> score.strikes++
                userAnswer.contains(c) -> score.balls++
                else -> score.outs++
            }
        }
        return score
    }
}