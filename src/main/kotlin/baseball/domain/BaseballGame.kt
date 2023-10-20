package baseball.domain

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
}