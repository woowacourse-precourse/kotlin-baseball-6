package baseball

import camp.nextstep.edu.missionutils.Console

class GameView {
    fun displayMessage(message: String) {
        println(message)
    }

    fun getUserInput(): String {
        return Console.readLine()
    }

    fun displayResult(result: String) {
        println(result)
    }

    fun displayGameWon() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun displayRestartOrExit() {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
    }
}
