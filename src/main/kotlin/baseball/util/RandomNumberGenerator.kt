package baseball.util

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {

    fun generate(): MutableList<Int> {
        val randomNumbers = mutableListOf<Int>()
        while (randomNumbers.size < MAX_NUMBER_DIGIT) {
            val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber)
            }
        }

        return randomNumbers
    }

    companion object {
        private const val MAX_NUMBER_DIGIT = 3
        private const val MIN_NUMBER_RANGE = 1
        private const val MAX_NUMBER_RANGE = 9
    }
}