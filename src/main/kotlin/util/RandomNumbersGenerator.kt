package util

import camp.nextstep.edu.missionutils.Randoms

object RandomNumbersGenerator {
    fun creatRandomNumbers(): MutableList<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numbers.contains(randomNumber)) numbers.add(randomNumber)
        }
        return numbers
    }
}