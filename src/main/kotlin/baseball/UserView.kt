package baseball

import baseball.model.UserInput
import camp.nextstep.edu.missionutils.Console

fun gameStartPrompt() {
    println("숫자 야구 게임을 시작합니다.")
}

/** [2&4]. 0) 입력을 위한 안내 문구 출력 (View) */
fun printInputPrompt(digit: Int, userInput: UserInput) {
    if (digit == BASEBALL_DIGITS) {
        print("숫자를 입력해주세요 : ")
    } else if (digit == MENU_DIGITS) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
    val content = Console.readLine() ?: ""
    userInput.setData(content)
}

/** [3]. 2) "S, B" 형태의 값에 따라 문구 출력, 정답을 맞췄는지 반환 (View) */
fun calculateResultPrint(ball: Int, strike: Int) {
    if (strike == BASEBALL_DIGITS) {
        println("${BASEBALL_DIGITS}스트라이크")
        println("${BASEBALL_DIGITS}개의 숫자를 모두 맞히셨습니다! 게임 종료")
    } else if (strike == 0 && ball == 0) {
        println("낫싱")
    } else if (strike != 0 || ball != 0) {
        var calculateResult = "${ball}볼".takeIf { ball != 0 } ?: ""
        calculateResult += " ${strike}스트라이크".takeIf { strike != 0 } ?: ""
        println(calculateResult.trim()) // 스트라이크만 출력 시 앞에 공백 제거
    }
}