package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUserNumber(): List<Int> {
        val userInputNumber = Console.readLine()
        Validation.checkInput(userInputNumber)
        return generateNumber(userInputNumber)
    }

    private fun generateNumber(input: String): List<Int> {
        return input.map { it.toString().toInt() }
    }

}