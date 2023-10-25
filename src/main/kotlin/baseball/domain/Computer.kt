package baseball.domain

import baseball.utils.Number.MAX_NUMBER
import baseball.utils.generateRandomNumbers

class Computer {

    fun generateComputerNumbers(): String {
        val computerNumbers = mutableSetOf<Int>()

        while (computerNumbers.size < MAX_NUMBER) {
            computerNumbers.add(generateRandomNumbers())
        }

        return computerNumbers.joinToString("")
    }
}