package baseball.utils

import baseball.resources.NINE
import baseball.resources.ONE
import camp.nextstep.edu.missionutils.Randoms

fun generateRandomNumbers(): Int = Randoms.pickNumberInRange(ONE, NINE)