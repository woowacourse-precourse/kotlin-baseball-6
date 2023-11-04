package baseball.view

import camp.nextstep.edu.missionutils.Console

class GameInputView {
    //플레이어 입력을 받는 함수
    fun getUserInput() = Console.readLine().toString() //플레이어 입력
    //재시작 여부를 받는 함수
    fun endGame(): Boolean {
        val userInput = Console.readLine()
        return when (userInput) {
            "1" -> false //종료 O, 재시작 X
            "2" -> true //종료 X , 재시작 O
            else -> throw IllegalArgumentException()
        }
    }
    fun makeUserInputList(userInput: String) = userInput.chunked(1)
}