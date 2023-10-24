package baseball

import kotlin.random.Random

class Pitcher(
    private val numberCount: Int,
    private val minNumber: Int,
    private val maxNumber: Int
) {
    private var numbers = listOf<Int>()

    fun generateNumbers() {
        val numbers = mutableListOf<Int>()

        for (i in 0..numberCount) {
            val number = Random.nextInt(maxNumber - 1) + minNumber
            numbers.add(number)
        }

        this.numbers = numbers
    }
}