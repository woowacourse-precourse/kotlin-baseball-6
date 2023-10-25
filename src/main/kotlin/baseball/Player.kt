package baseball

import baseball.util.GameState.GAME_RESTART_MESSAGE
import baseball.util.GameState.NUMBER_INPUT_MESSAGE
import baseball.util.GameValue.RESTART_COMMAND
import baseball.util.Validator
import camp.nextstep.edu.missionutils.Console

object Player {
    fun inputNumber(): List<Int> {
        print(NUMBER_INPUT_MESSAGE)
        val input = Console.readLine()
        Validator.checkValidity(input)

        val number = mutableListOf<Int>()
        input.forEach {
            number.add(it - '0')
        }
        return number
    }

    fun restartQuestion(): Boolean {
        println(GAME_RESTART_MESSAGE)
        val playerCommend = Console.readLine()
        Validator.commendCheck(playerCommend)
        return playerCommend == RESTART_COMMAND
    }
}
