package baseball.domain

class BaseBallGame {
    private var randomNumber: MutableList<Int> = GenerateRandomNumber().generate()
    private var gameState: GameResult = GameResult.Lose
    private var choiceState: ChoiceState = ChoiceState.Start

    init {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun playGame(userNumber: Int, compareNumbers: CompareNumbers): Map<BallCount, Int> {
        val gameResult = compareNumbers.compareEachNumbers(randomNumber, userNumber)
        setGameResult(gameResult)
        return compareNumbers.compareEachNumbers(randomNumber, userNumber)
    }

    private fun setGameResult(gameResult: Map<BallCount, Int>) {
        gameState = if (gameResult[BallCount.Strike] == 3) {
            GameResult.Win
        } else {
            GameResult.Lose
        }
    }

    fun restartGame() {
        randomNumber = GenerateRandomNumber().generate()
        gameState = GameResult.Lose
        choiceState = ChoiceState.Restart
    }

    fun exitGame() {
        choiceState = ChoiceState.Exit
    }

    fun getGameState() = choiceState


    fun isPlaying(): GameResult {
        return gameState
    }
}