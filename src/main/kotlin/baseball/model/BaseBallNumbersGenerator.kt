package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class BaseBallNumbersGenerator:NumbersGenerator {
    override fun generate(): MutableList<Int> {
        val result = mutableListOf<Int>()
        while (result.size < 3) {
            val randomNum = Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM)
            if (!result.contains(randomNum)) result.add(randomNum)
        }
        return result
    }

    companion object {
        const val RANDOM_MAX_NUM = 9
        const val RANDOM_MIN_NUM = 1
    }

}