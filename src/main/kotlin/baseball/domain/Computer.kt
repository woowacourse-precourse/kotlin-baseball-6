package baseball.domain

import baseball.resources.*
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