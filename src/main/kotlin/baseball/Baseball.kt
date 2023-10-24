package baseball

class Baseball {
    private val pitcher: Pitcher
    private val batter: Batter
    private val referee: Referee
    private val numberCount = 3
    private val minNumber = 1
    private val maxNumber = 9

    init {
        pitcher = Pitcher(numberCount, minNumber, maxNumber)
        batter = Batter(numberCount, minNumber, maxNumber)
        referee = Referee()
        printStartMessage()
    }

    private fun printStartMessage() {
        val message = "숫자 야구 게임을 시작합니다"
        println(message)
    }

    fun runGame() {
        pitcher.generateNumbers()
        batter.enterNumbers()
    }
}