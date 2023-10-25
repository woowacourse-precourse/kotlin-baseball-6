package baseball

import baseball.constants.GameConfig
import baseball.constants.Message


fun gameStartPrompt() = println(Message.GAME_START)
fun gameEndPrompt() = println(Message.GAME_END)


/** [2&4]. 0) 입력을 위한 안내 문구 출력 (View) */
fun printInputPrompt(digit: Int) {
    // 코드 컨벤션의 is vs when 에서는 3개 이상일 때만, when을 권장하지만 가독성 측면에서 when이 더 깔끔함.
    when (digit) {
        GameConfig.BASEBALL_DIGITS -> print(Message.INPUT_BASEBALL)
        GameConfig.MENU_DIGITS -> println(Message.INPUT_MENU)
    }
}

/** [3]. 2) "S, B" 형태의 값에 따라 문구 출력, 정답을 맞췄는지 반환 (View) */
fun calculateResultPrint(ball: Int, strike: Int) {
    when {
        strike == GameConfig.BASEBALL_DIGITS -> println(Message.RESULT_ALL_STRIKE)
        strike == 0 && ball == 0 -> println(Message.RESULT_NOTHING)
        strike != 0 || ball != 0 -> {
            var calculateResult = ""
            calculateResult += "$ball${GameConfig.BALL}".takeIf { ball != 0 }
            calculateResult += " $strike${GameConfig.STRIKE}".takeIf { strike != 0 } ?: ""
            println(calculateResult.trim()) // 스트라이크만 출력 시 앞에 공백 제거
        }
    }
}