package baseball

import baseball.util.GameValue.COMPUTER_MAX_NUMBER
import baseball.util.GameValue.COMPUTER_MIN_NUMBER
import baseball.util.GameValue.GAME_NUMBER_LENGTH
import camp.nextstep.edu.missionutils.Randoms

object Computer {

    fun makeNumber(): List<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size != GAME_NUMBER_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(COMPUTER_MIN_NUMBER, COMPUTER_MAX_NUMBER)
            computerNumber.add(randomNumber)
            computerNumber.distinct()
        }
        return computerNumber
    }
}
