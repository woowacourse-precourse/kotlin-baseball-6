package baseball.view

import baseball.model.BallAndStrike

class OutputView {
    fun showStartPrompt() = println(START_PROMPT)
    fun showSuccessPrompt() = println(SUCCESS_PROMPT)

    fun showTurnResult(ballAndStrike: BallAndStrike) = println(ballAndStrike)

    companion object {
        const val START_PROMPT = "숫자 야구 게임을 시작합니다."
        const val SUCCESS_PROMPT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    }
}