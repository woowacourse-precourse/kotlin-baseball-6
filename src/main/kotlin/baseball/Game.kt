package baseball

class Game {
    companion object {
        private const val NOTHING = "낫싱"
        private const val STRIKE = "스트라이크"
        private const val BALL = "볼"
    }

    private val user = User()
    private val computer = Computer()

    fun run() {
        printGameStartMessage()
        gameStart()
    }

    private fun printGameStartMessage() = println("숫자 야구 게임을 시작합니다.")

    private fun gameStart() {
        var computerNumber = computer.setComputerNumber()
        var isGameEnd = false

        while (!isGameEnd) {
            val userNumber = user.inputUserNumber()
            val hint = computer.countStrikeAndBall(computerNumber, userNumber)
            isGameEnd = computer.checkGameEnd(hint.first)
            printHint(hint)

            if (isGameEnd) {
                printGameEndMessage()
                val restartGame = user.decideGame()
                if (restartGame) {
                    isGameEnd = false
                    computerNumber = computer.setComputerNumber()
                }
            }
        }
    }

    private fun printHint(hint: Pair<Int, Int>) {
        val (strike, ball) = hint
        val resultHint = when {
            strike == 0 && ball == 0 -> NOTHING
            strike > 0 && ball == 0 -> "$strike$STRIKE"
            strike == 0 && ball > 0 -> "$ball$BALL"
            else -> "$ball$BALL $strike$STRIKE"
        }

        println(resultHint)
    }

    private fun printGameEndMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}