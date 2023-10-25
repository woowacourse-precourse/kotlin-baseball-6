package baseball.utils

import baseball.utils.Number.NINE
import baseball.utils.Number.ONE
import camp.nextstep.edu.missionutils.Randoms

fun generateRandomNumbers(): Int = Randoms.pickNumberInRange(ONE, NINE)