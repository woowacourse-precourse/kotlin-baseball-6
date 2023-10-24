package view

import camp.nextstep.edu.missionutils.Console
import constants.Constant.COUNT
import constants.Constant.RESTART_STRING
import constants.Constant.TERMINATION_STRING

class BaseballView {

    fun getUserNumber(): IntArray {
        print("숫자를 입력해주세요 : ")
        val userInput = Console.readLine().split("").drop(1).dropLast(1)  // split함수의 시작과 끝에 추가되는 빈 문자열 제거
        if (userInput.any { it.toInt() in 48..57 } || userInput.size != COUNT) {    // 입력값이 아스키코드로 48(숫자0) ~ 57(숫자9)에 포함되지 않거나
            throw IllegalArgumentException()                                             // 길이가 COUNT와 같지 않으면 올바르지 않은 입력값으로 에러발생
        } else return userInput.map { it.toInt() }.toIntArray()                         // 입력값을 정수배열로 반환
    }

    fun printResult(strike: Int, ball: Int) {
        when {
            strike == 0 && ball == 0 -> println("낫싱")                  // 하나도 없는 경우
            strike > 0 && ball == 0 -> println("${strike}스트라이크")    // 스트라이크만 있는 경우
            ball > 0 && strike == 0 -> println("${ball}볼")           // 볼만 있는 경우
            else -> println("${ball}볼 ${strike}스트라이크")           // 볼과 스트라이크가 같이 있는 경우
        }
    }

    fun askRestart(): String {
        println("게임을 새로 시작하려면 ${RESTART_STRING}, 종료하려면 ${TERMINATION_STRING}를 입력하세요.")
        return Console.readLine()
    }

    fun printGameEnd() {
        println("${COUNT}개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}
