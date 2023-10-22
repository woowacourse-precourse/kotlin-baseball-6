package baseball.view

import camp.nextstep.edu.missionutils.Console

class BaseballView {

    fun showStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun getUserInput(): List<Int> {
        println("숫자를 입력해주세요 :")
        val userInput = Console.readLine() ?: throw IllegalArgumentException("올바른 입력이 아닙니다.")

        // 사용자 입력값을 정수 리스트로 변환
        val userNumbers = userInput.map { it.toString().toInt() }

        return userNumbers
    }

    fun showResult(result: String) {
        println(result)
    }

    fun showEndGameMessage() {
        println("게임이 종료되었습니다.")
    }
}