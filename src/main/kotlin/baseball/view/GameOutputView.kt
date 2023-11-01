package baseball.view

import baseball.util.C

class GameOutputView {
    //게임 시작을 출력하는 함수
     fun printGameStart() {
        println(C.GAME_START_MSG)
    }
    //게임 결과를 출력하는 함수
     fun printGameResult(result: Pair<Int, Int>) {
        val (strike, ball) = result
        val resultText = when {
            strike > 0 && ball == 0 -> "$strike${C.STRIKE_STRING}"
            strike == 0 && ball > 0 -> "$ball${C.BALL_STRING}"
            strike == 0 && ball == 0 -> C.NOTHING
            else -> "$ball${C.BALL_STRING} $strike${C.STRIKE_STRING}"
        }
        println(resultText)
    }
    //게임 종료를 출력하는 함수
    fun printGameEnded() {
        println(C.GAME_END_MSG)
        println(C.GAME_RESTART_MSG)
    }
}