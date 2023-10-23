package baseball.view

import camp.nextstep.edu.missionutils.Console


class ReadUserRestartChoiceView {

    fun readUserRestartInput(): String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return Console.readLine()
    }

}