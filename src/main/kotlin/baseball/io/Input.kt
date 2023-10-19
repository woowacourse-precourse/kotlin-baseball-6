package baseball.io

import baseball.util.validateInputBaseBall
import camp.nextstep.edu.missionutils.Console

fun inputBaseBallNumber(): List<Int> {
    val inputBaseBallNumber = Console.readLine().map { it ->
        it.code - '0'.code
    }

    validateInputBaseBall(inputBaseBallNumber)
    return inputBaseBallNumber
}