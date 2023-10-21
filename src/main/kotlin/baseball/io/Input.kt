package baseball.io

import baseball.util.toDigitList
import baseball.util.validateInputBaseBall
import baseball.util.validateInputExit
import camp.nextstep.edu.missionutils.Console

fun inputBaseBallNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val inputBaseBallNumber = Console.readLine().toDigitList()

    validateInputBaseBall(inputBaseBallNumber)
    return inputBaseBallNumber
}

fun inputExitGame(): String {
    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val exitGame = Console.readLine()
    validateInputExit(exitGame)

    return exitGame
}