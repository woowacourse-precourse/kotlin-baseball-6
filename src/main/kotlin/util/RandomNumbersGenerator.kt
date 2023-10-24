package util

import camp.nextstep.edu.missionutils.Randoms

object RandomNumbersGenerator {
    fun create(count: Int, startInclusive: Int, endInclusive: Int): MutableList<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < count) {
            val randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive)
            if (!numbers.contains(randomNumber)) numbers.add(randomNumber)
        }
        return numbers
    }
}