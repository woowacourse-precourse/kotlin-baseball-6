package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    baseballGame()
}

fun baseballGame(): Unit {
    var restartGame = true
    while (restartGame) {
        // 매 게임의 타겟 숫자 3개 선택
        var randomNumbers = mutableListOf<Int>()
        for (i in 0..2) {
            randomNumbers.add(Randoms.pickNumberInRange(1, 9))
        }

        // 게임 종료
        restartGame = inputRestart()
    }
}


fun inputRestart(): Boolean {
    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ")
    val inputAfterGameOver = Console.readLine()
    if (inputAfterGameOver != "1" && inputAfterGameOver != "2") {
        throw IllegalArgumentException("1, 2 이외의 다른 입력 발생")
    }

    val gameRestartOption = inputAfterGameOver.toInt()
    if (gameRestartOption == 1) {
        return true
    }
    return false
}
