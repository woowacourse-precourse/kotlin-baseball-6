package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballConsole {
    fun printWelcomeMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun getInput(): String? {
        print("숫자를 입력해주세요 : ")
        return Console.readLine()
    }

    fun printResult(result: BaseballResult) {
        println(result)
    }

    fun printEndMessage() {
        println(
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        )
    }

    fun getEndFlag(): String? {
        return Console.readLine()
    }
}