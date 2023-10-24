package baseball.model

import baseball.util.Constants.TEXT_ASK_RESTART
import baseball.util.Constants.TEXT_INPUT_NUMBER
import baseball.util.Validation.validateDigit
import baseball.util.Validation.validateDuplicate
import baseball.util.Validation.validateLength
import baseball.util.Validation.validateRestartFlag
import camp.nextstep.edu.missionutils.Console

object Player {
    fun inputNumber(): MutableList<Int> {
        print(TEXT_INPUT_NUMBER)

        val number = mutableListOf<Int>()
        val input = Console.readLine()

        input.forEach {
            number.add(validateDigit(it))
        }

        validateLength(number)
        validateDuplicate(number)

        return number
    }

    fun askRestart(): String {
        println(TEXT_ASK_RESTART)

        val restartFlag = Console.readLine()

        validateRestartFlag(restartFlag)

        return restartFlag
    }
}