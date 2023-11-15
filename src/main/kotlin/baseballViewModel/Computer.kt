package baseballViewModel

import camp.nextstep.edu.missionutils.Randoms

class Computer{
    fun createComputer():String {
        val uniqueNumbers = mutableSetOf<Int>()
        while (uniqueNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            uniqueNumbers.add(randomNumber)
        }
        return uniqueNumbers.joinToString("")
    }
}