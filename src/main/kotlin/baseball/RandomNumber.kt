package baseball

import camp.nextstep.edu.missionutils.Randoms

object RandomNumber {

    fun generateRandomNumbers(): Int = Randoms.pickNumberInRange(1, 9)
}