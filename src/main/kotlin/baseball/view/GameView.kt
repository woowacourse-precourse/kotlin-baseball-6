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
        println("숫자를 입력해주세요 : ")
        val userInput = Console.readLine()

        // 사용자 입력 값이 null, 정수가 아닐 경우 예외처리
        while (userInput == null || !userInput.all { it.isDigit() }) {
            throw IllegalArgumentException("올바른 입력이 아닙니다.")
        }
        // 중복되지 않은 3자리 값이 아닐 경우 예외처리
        while (userInput.toSet().size != 3) {
            throw IllegalArgumentException("올바른 입력이 아닙니다.")
        }

        return userInput.chunked(1).map { it.toInt() }
    }

    //결과호출
    fun showResult(result: String) {
        println(result)
    }

    //게임 재시작
    fun restartInputLine(): String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var restart = Console.readLine()
        while (restart != "1" && restart != "2") {
            throw IllegalArgumentException("올바른 입력이 아닙니다. \n값을 다시 입력해주세요.")
        }
        return restart
    }

    //게임종료
    fun showEndGameMessage() {
        println("게임이 종료되었습니다.")
    }
}