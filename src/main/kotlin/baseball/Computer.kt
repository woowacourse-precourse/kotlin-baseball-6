package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {

    fun generateNumber(): List<Int>{
        val comNumber = mutableListOf<Int>()
        while (comNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber)
            }
        }
        return comNumber
    }
}