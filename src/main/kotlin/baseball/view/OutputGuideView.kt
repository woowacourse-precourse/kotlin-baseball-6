package baseball.view

import baseball.config.GameMsg.GAME_OVER
import baseball.config.GameMsg.START_GAME

class OutputGuideView {
    fun showStartMsg() {
        println(START_GAME)
    }

    fun showEndMsg() {
        println(
            GAME_OVER
        )
    }
}