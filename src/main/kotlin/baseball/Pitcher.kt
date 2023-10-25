package baseball

import camp.nextstep.edu.missionutils.Randoms

class Pitcher(
    private val numberCount: Int,
    private val minNumber: Int,
    private val maxNumber: Int
) {
    private var numbers = listOf<Int>()

    fun getNumbers() = this.numbers

    fun generateNumbers() {
        val numbers = mutableListOf<Int>()

        while (numbers.size != numberCount) {
            val number = Randoms.pickNumberInRange(minNumber, maxNumber)
            if (!numbers.contains(number)) numbers.add(number)
        }

        this.numbers = numbers
    }
}