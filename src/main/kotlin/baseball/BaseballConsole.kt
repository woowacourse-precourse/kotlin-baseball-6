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
}