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

    val scoreBoard: HashMap<String, Int> = hashMapOf(Pair("strike", 0), Pair("ball", 0))


    fun startGame() {
        setGameState(GameState.INPROGRESS)
        targetNumber = randomTargetGenerator.generateRandomTarget()
    }

    fun calculateStrikeBall(playerInput: List<Int>) {
        calculateStrike(playerInput)
        calculateBall(playerInput)
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
            if (value in targetNumber && targetNumber[index] != value){
                scoreBoard["ball"] = scoreBoard["ball"]!! + 1
            }
        }
    }

    private fun setGameState(gameState: GameState) {
        this.gameState = gameState
    }
}