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

            print("숫자를 입력해주세요 : ")
            Player.inputNumber()
            val playerNumber = Player.getNumber()

            Hint.compareNumber(playerNumber, computerNumber)
            val count = GameCount.getCount()
            Hint.printHint(count)
        } while (!isAnswer())
        // 정답을 맞춘 후 실행됨
        askRestartOrFinish()
    }

    private fun reStart() {
        startBaseballGame()
    }

    private fun isAnswer(): Boolean {
        val (ball, strike) = GameCount.getCount()
        return (ball == 0 && strike == 3)
    }

    private fun askRestartOrFinish() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val inputRestartOrFinish = Console.readLine().toInt()
        checkRestartOrFinish(inputRestartOrFinish)
    }

    private fun checkRestartOrFinish(playerInput: Int) {
        when (playerInput) {
            1 -> reStart()
            2 -> println("게임 종료")
            else -> throw IllegalArgumentException("1또는 2가 입력되지 않았습니다!")
        }
    }
}