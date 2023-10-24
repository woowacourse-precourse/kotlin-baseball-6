package baseball

import baseball.util.GameState
import baseball.util.GameState.NUMBER_INPUT_MESSAGE
import baseball.util.GameValue
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
        return number.toList()
    }

    fun restartQuestion(): Boolean {
        println(GameState.GAME_RESTART_MESSAGE)
        val playerCommend = Console.readLine()
        Validator.commendCheck(playerCommend)
        return playerCommend == GameValue.RESTART_COMMAND
    }
}
