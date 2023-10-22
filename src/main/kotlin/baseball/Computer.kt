package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    fun createRandomNumber(): List<Int> {
        val randomNumberList = mutableListOf<Int>()
        while (randomNumberList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber)
            }
        }
        return randomNumberList
    }
}