package baseball.manager

import baseball.console.GameConsole.answer
import baseball.console.GameConsole.computerNumber

class ScoreManager {

    // 스코어를 계산하는 함수입니다.
    fun scoreFromAnswer(): Pair<Int, Int> {
        var ball = 0
        var strike = 0

        for (index in answer.indices) {
            if (strikeCounter(index)) strike += 1
            else if (ballCounter(index)) ball += 1
        }
        return Pair(ball, strike)
    }

    // 스트라이크를 카운트 합니다.
    private fun strikeCounter(index: Int): Boolean =
        computerNumber[index] == answer[index]

    // 볼을 카운트 합니다.
    private fun ballCounter(index: Int): Boolean =
        computerNumber.contains(answer[index])
}