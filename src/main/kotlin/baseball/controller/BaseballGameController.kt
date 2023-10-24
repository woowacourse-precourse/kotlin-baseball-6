package baseball.controller

import baseball.domain.Constants
import baseball.domain.computer.Computer
import baseball.domain.game.BaseballGame
import baseball.view.InputView
import baseball.view.OutputView

object BaseballGameController {

    fun start() {
        val computerNumbers = Computer.setRandomNumbers()
        println(Constants.GAME_START_MESSAGE)

        val game = BaseballGame(computerNumbers)

        var strikes = 0
        while (strikes < 3) {
            val userNumbers = InputView.readNumbers()
            val (newStrikes, balls) = game.play(userNumbers)
            strikes = newStrikes

            OutputView.showResult(balls, newStrikes)
        }

        println(Constants.GAME_END_MESSAGE)
        retry()
    }

    private fun retry() {
        println(Constants.GAME_RETRY_MESSAGE)
        val input = readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)

        when (input) {
            "1" -> start()
            "2" -> return
            else -> throw IllegalArgumentException(Constants.NOT_RETRY_TYPE_ERROR_MESSAGE)
        }
    }
}
