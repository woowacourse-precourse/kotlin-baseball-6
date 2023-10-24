package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val comNumber = mutableListOf<Int>()

    fun generateNumber(): MutableList<Int>{
        comNumber.clear()
        while (comNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber)
            }
        }
        return comNumber
    }
}