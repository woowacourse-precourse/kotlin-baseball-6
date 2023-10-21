package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class BaseballModel {
    fun createRandomNumber(): String {
        val answerNumber = mutableListOf<Int>()
        while (answerNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber)
            }
        }
        return answerNumber.joinToString("")
    }

    fun calculateHint(answerNumber: String, userNumber: String): BaseballResult {
        var strikes = 0
        var balls = 0
        var nothing = 0
        for (i in 0 until 3) {
            if (answerNumber[i] == userNumber[i]) {
                strikes++
            } else if (userNumber.contains(answerNumber[i])) {
                balls++
            } else {
                nothing++
            }
        }
        return BaseballResult(strikes, balls, nothing)
    }
}