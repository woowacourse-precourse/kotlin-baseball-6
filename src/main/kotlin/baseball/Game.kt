package baseball

import camp.nextstep.edu.missionutils.Console

object Game {
    fun start() {
        println("숫자 야구 게임을 시작합니다.")
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
        return (ball == 0 && strike == 3)
    }
}