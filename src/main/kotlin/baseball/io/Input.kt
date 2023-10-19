package baseball.io

import baseball.util.validateInputBaseBall
import camp.nextstep.edu.missionutils.Console

fun inputBaseBallNumber(): List<Int> {
    val inputBaseBallNumber = Console.readLine().map {
        it.code - '0'.code
    }

    validateInputBaseBall(inputBaseBallNumber)
    return inputBaseBallNumber
}

fun inputExitGame(): String {
    val exitGame = Console.readLine()
    validateInputExit(exitGame)

    return exitGame
}