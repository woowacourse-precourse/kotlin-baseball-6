package baseball

import camp.nextstep.edu.missionutils.Console


fun main() {
    do {
        val baseBall = BaseBall()
        baseBall.startGame()
    } while (checkRestart())
}


fun checkRestart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException(WRONG_INPUT_MESSAGE)
    }
}