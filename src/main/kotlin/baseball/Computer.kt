package baseball

import baseball.util.GameValue.GAME_NUMBER_LENGTH
import camp.nextstep.edu.missionutils.Randoms

object Computer {

    fun makeNumber(): List<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size != GAME_NUMBER_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            computerNumber.add(randomNumber)
        }
        return computerNumber.toList()
    }
}