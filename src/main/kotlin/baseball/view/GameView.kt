package baseball.view

import camp.nextstep.edu.missionutils.Console

/*
김영현-Agilecatch
GameView 클래스는 게임의 화면 표시와 관련된 역할을 합니다.
게임 시작 메시지를 출력하고, 사용자로부터 숫자를 입력 받습니다. 그리고 게임 결과를 표시하며, 게임이 종료될 때 종료 메시지를 출력합니다.
 */
class GameView {

    //게임시작
    fun showStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    //숫자입력
    fun getUserInput(): List<Int> {
        println("숫자를 입력해주세요 :")
        val userInput = Console.readLine() ?: throw IllegalArgumentException("올바른 입력이 아닙니다.")

        // 사용자 입력값을 정수 리스트로 변환
        val userNumbers = userInput.map { it.toString().toInt() }

        return userNumbers
    }

    //결과호출
    fun showResult(result: String) {
        println(result)
    }

    //게임종료
    fun showEndGameMessage() {
        println("게임이 종료되었습니다.")
    }
}