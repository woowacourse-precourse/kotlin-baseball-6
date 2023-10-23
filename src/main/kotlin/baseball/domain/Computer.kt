package baseball.domain

import baseball.utils.Number.MAX_NUMBER
import baseball.utils.RandomNumber

object Computer {

    fun generateComputerNumbers(): String {
        val computerNumbers = mutableSetOf<Int>()

        while (computerNumbers.size < MAX_NUMBER) {
            computerNumbers.add(RandomNumber.generateRandomNumbers())
        }

        return computerNumbers.joinToString("")
    }
}