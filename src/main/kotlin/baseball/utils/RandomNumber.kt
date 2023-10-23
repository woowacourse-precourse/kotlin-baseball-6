package baseball.utils

import baseball.utils.Number.NINE
import baseball.utils.Number.ONE
import camp.nextstep.edu.missionutils.Randoms

object RandomNumber {
    fun generateRandomNumbers(): Int = Randoms.pickNumberInRange(ONE, NINE)
}