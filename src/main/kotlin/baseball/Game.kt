package baseball

import baseball.Constant.CORRECT_THREE_NUMBERS_MESSAGE
import baseball.Constant.FINISH_BASEBALL_GAME_MESSAGE
import baseball.Constant.START_BASEBALL_GAME_MESSAGE
import baseball.Constant.THREE_STRIKE
import baseball.Constant.ZERO_BALL

object Game {
    fun start() {
        println(START_BASEBALL_GAME_MESSAGE)
        startBaseballGame()
    }

    private fun startBaseballGame() {
        Computer.setNumber()
        val computerNumber = Computer.getNumber()
        do {
            GameCount.resetCount()

            Computer.askNumber()
            Player.inputNumber()
            val playerNumber = Player.getNumber()

            Hint.compareNumber(playerNumber, computerNumber)
            val count = GameCount.getCount()
            Hint.printHint(count)
        } while (!isAnswer())
        // 정답을 맞춘 후 실행됨
        Computer.askRestartOrFinish()
        Player.inputRestartOrEnd()
    }

    fun reStart() {
        startBaseballGame()
    }

    private fun isAnswer(): Boolean {
        val (ball, strike) = GameCount.getCount()
        return (ball == ZERO_BALL && strike == THREE_STRIKE)
    }
}