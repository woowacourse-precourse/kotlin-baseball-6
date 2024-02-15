package baseball.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        fun printGameStartMessage() {
            println("숫자 야구 게임을 시작합니다.")
        }

        fun getInputNumbers(): String {
            print("숫자를 입력해주세요 : ")
            return Console.readLine()
        }

        fun isReStart(): Boolean {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            return Console.readLine().toInt() == 1
        }

    }
}