package baseballViewModel

import baseballViewModel.ValidInput.Companion.size_limit
import camp.nextstep.edu.missionutils.Randoms

class Computer{
    fun createComputer():String {
        val uniqueNumbers = mutableSetOf<Int>()
        while (uniqueNumbers.size < size_limit) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            uniqueNumbers.add(randomNumber)
        }
        return uniqueNumbers.joinToString("")
    }
}