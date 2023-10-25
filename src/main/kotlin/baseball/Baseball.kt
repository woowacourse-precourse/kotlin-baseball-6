package baseball

class Baseball(
    private val numberCount: Int,
    private val minNumber: Int,
    private val maxNumber: Int
) {
    private val pitcher: Pitcher = Pitcher(numberCount, minNumber, maxNumber)
    private val batter: Batter = Batter(numberCount, minNumber, maxNumber)
    private val referee: Referee = Referee()

    init {
        printStartMessage()
    }

    fun runGame() {
        pitcher.generateNumbers()

        do {
            batter.enterNumbers()
            referee.judge(pitcher.getNumbers(), batter.getNumbers())
            println(referee.getResultMessage())
        } while (referee.getResultMessage() != "3스트라이크")

        printEndMessage()
    }

    private fun printStartMessage() {
        val message = "숫자 야구 게임을 시작합니다"
        println(message)
    }

    private fun printEndMessage() {
        val message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        println(message)
    }
}
