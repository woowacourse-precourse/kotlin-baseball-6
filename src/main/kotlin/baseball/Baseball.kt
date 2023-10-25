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

    private fun printStartMessage() {
        val message = "숫자 야구 게임을 시작합니다"
        println(message)
    }

    fun runGame() {
        pitcher.generateNumbers()
        batter.enterNumbers()
        referee.judge(pitcher.getNumbers(), batter.getNumbers())
        referee.showResult()
    }
}