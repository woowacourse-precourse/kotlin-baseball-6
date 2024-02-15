package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class Computer (numberSize: Int) {

    val numbers = mutableListOf<Int>()

    init {
        getComputerNumbers(numberSize)
    }

    private fun getComputerNumbers(numberSize: Int): MutableList<Int> {
        while (numbers.size < numberSize) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
        return numbers
    }
}