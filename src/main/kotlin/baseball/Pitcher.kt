package baseball

import kotlin.random.Random

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
            val number = Random.nextInt(maxNumber) + minNumber
            if (!numbers.contains(number)) numbers.add(number)
        }

        this.numbers = numbers
    }
}