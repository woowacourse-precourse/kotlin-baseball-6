package baseball

class GameManager {

    enum class GameState {
        INIT, INPROGRESS, ENDED
    }

    var gameState: GameState = GameState.INIT
        private set

    private val randomTargetGenerator: RandomTargetGenerator by lazy { RandomTargetGenerator() }

    lateinit var targetNumber: List<Int>
        private set

    private val scoreBoard: HashMap<String, Int> = hashMapOf("strike" to 0, "ball" to 0)

    fun startGame() {
        setGameState(GameState.INPROGRESS)
        targetNumber = randomTargetGenerator.generateRandomTarget()
    }

    private fun endGame() {
        setGameState(GameState.ENDED)
    }

    fun calculateStrikeBall(playerInput: List<Int>) {
        calculateStrike(playerInput)
        calculateBall(playerInput)
        printStrikeBallNothing()

        if (scoreBoard["strike"] == 3) {
            endGame()
        }
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
        if (scoreBoard["strike"]!! == 0 && scoreBoard["ball"]!! == 0) {
            print("낫싱")
        }
        if (scoreBoard["ball"]!! >= 1) {
            print("${scoreBoard["ball"].toString()}볼")
        }
        if (scoreBoard["strike"]!! >= 1) {
            print(" ${scoreBoard["strike"].toString()}스트라이크")
        }
    }

    private fun setGameState(gameState: GameState) {
        this.gameState = gameState
    }

    fun getScoreBoard(): HashMap<String, Int> {
        return hashMapOf("strike" to scoreBoard["strike"]!!, "ball" to scoreBoard["ball"]!!)
    }
}