package baseball.model

import baseball.util.Constants.TEXT_INPUT_NUMBER
import camp.nextstep.edu.missionutils.Console

object Player {
    fun inputNumber(): MutableList<Int> {
        print(TEXT_INPUT_NUMBER)

        val number = mutableListOf<Int>()
        val input = Console.readLine()

        input.forEach {
            number.add(Character.getNumericValue(it))
        }

        return number
    }
}