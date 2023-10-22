package baseball

import java.lang.IllegalArgumentException

class GameManager {

    companion object{
        private const val INITIAL_SCORE = 0
        private const val MAX_STRIKES = 3
    }

    enum class GameState {
        INIT, INPROGRESS, ENDED
    }

    enum class GameAction(val value: Int) {
        RESTART(1),
        EXIT(2)
    }

    init {
        println("숫자 야구 게임을 시작합니다.")
    }

    var gameState: GameState = GameState.INIT

    private val randomTargetGenerator: RandomTargetGenerator by lazy { RandomTargetGenerator() }

    lateinit var targetNumber: List<Int>
        private set

    private val scoreBoard: HashMap<String, Int> = hashMapOf("strike" to INITIAL_SCORE, "ball" to INITIAL_SCORE)

    fun startGame() {
        gameState = GameState.INPROGRESS
        targetNumber = randomTargetGenerator.generateRandomTarget()
    }

    fun calculateStrikeBall(playerInput: List<Int>) {
        clearScore()
        calculateStrike(playerInput)
        calculateBall(playerInput)
        printStrikeBallNothing()
        endGameIfThreeStrikes()
    }

    private fun calculateStrike(playerInput: List<Int>) {
        playerInput.forEachIndexed { index, value ->
            if (targetNumber[index] == value) {
                scoreBoard["strike"] = scoreBoard["strike"]!! + 1
            }
        }
    }

    private fun calculateBall(playerInput: List<Int>) {
        playerInput.forEachIndexed { index, value ->
            if (value in targetNumber && targetNumber[index] != value) {
                scoreBoard["ball"] = scoreBoard["ball"]!! + 1
            }
        }
    }

    private fun printStrikeBallNothing() {
        val strikeCount = scoreBoard["strike"]
        val ballCount = scoreBoard["ball"]

        if (strikeCount == INITIAL_SCORE && ballCount == INITIAL_SCORE) {
            print("낫싱")
        }
        if (ballCount != INITIAL_SCORE) {
            print("${ballCount.toString()}볼 ")
        }
        if (strikeCount != INITIAL_SCORE) {
            print("${strikeCount.toString()}스트라이크")
        }
        println()
    }

    private fun endGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        gameState = GameState.ENDED
    }

    fun handlePlayerChoiceAfterGame(playerChoice: String) {
        validatePlayerChoice(playerChoice)

        when (playerChoice.toInt()) {
            GameAction.RESTART.value -> {
                gameState = GameState.INPROGRESS
            }

            GameAction.EXIT.value -> {
                gameState = GameState.ENDED
            }

            else -> {
                throw IllegalArgumentException("알 수 없는 오류 입니다.")
            }
        }
    }

    private fun validatePlayerChoice(playerChoice: String) {
        requireNotNull(playerChoice.toIntOrNull()) {
            "숫자만 입력하실 수 있습니다."
        }
        require(playerChoice.toInt() == GameAction.RESTART.value || playerChoice.toInt() == GameAction.EXIT.value) {
            "1 혹은 2만 입력하실 수 있습니다."
        }
    }

    fun getScoreBoard(): HashMap<String, Int> {
        return hashMapOf("strike" to scoreBoard["strike"]!!, "ball" to scoreBoard["ball"]!!)
    }

    private fun endGameIfThreeStrikes() {
        if (scoreBoard["strike"] == MAX_STRIKES) {
            endGame()
        }
    }

    private fun clearScore() {
        scoreBoard["strike"] = INITIAL_SCORE
        scoreBoard["ball"] = INITIAL_SCORE
    }
}