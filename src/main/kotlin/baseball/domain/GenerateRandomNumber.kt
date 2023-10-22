package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class GenerateRandomNumber {

    fun generate(): MutableList<Int> {
        val randomNumbers = mutableListOf<Int>()
        while (randomNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber)
            }
        }

        return randomNumbers
    }
}