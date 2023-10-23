package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    fun getNumberInput(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val userInput = Console.readLine()
        return when {
            userInput.length != 3 -> throw IllegalArgumentException()
            userInput.toIntOrNull() == null -> throw IllegalArgumentException()
            listOf(
                userInput[0],
                userInput[1],
                userInput[2]
            ).distinct().size != 3 -> throw IllegalArgumentException()

            else -> listOf(
                userInput[0].digitToInt(),
                userInput[1].digitToInt(),
                userInput[2].digitToInt()
            )
        }
    }
}
