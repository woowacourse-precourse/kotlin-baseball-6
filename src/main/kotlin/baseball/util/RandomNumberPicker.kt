package baseball.util

import camp.nextstep.edu.missionutils.Randoms

const val DEFAULT_START_INCLUSIVE = 1
const val DEFAULT_END_INCLUSIVE = 9

class RandomNumberPicker(
    private val startInclusive: Int = DEFAULT_START_INCLUSIVE,
    private val endInclusive: Int = DEFAULT_END_INCLUSIVE,
) : NumberPicker {
    override fun pick() = Randoms.pickNumberInRange(startInclusive, endInclusive)
}