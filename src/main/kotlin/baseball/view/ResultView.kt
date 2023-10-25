package baseball.view

import camp.nextstep.edu.missionutils.Console

class ResultView {
    fun printStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun askForRestart(): Boolean{
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return Console.readLine().toInt() != 2
    }
}