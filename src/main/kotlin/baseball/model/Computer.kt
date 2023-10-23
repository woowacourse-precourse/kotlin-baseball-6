package baseball.model

import baseball.util.Constants.LENGTH_NUMBER
import baseball.util.Constants.MAX_DIGIT
import baseball.util.Constants.MIN_DIGIT
import camp.nextstep.edu.missionutils.Randoms

object Computer {
    fun getRandomNum(): MutableList<Int> {
        val numList = mutableListOf<Int>()
        while (numList.size < LENGTH_NUMBER) {
            val randomNumber = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT)
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber)
            }
        }
        return numList
    }
}