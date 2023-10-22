package baseball

class GameManager {

    enum class GameState {
        WAITING, INPROGRESS, ENDED
    }

    lateinit var targetNumber: List<Int>
        private set

    var gameState: GameState = GameState.WAITING
        private set

    private val randomTargetGenerator: RandomTargetGenerator by lazy { RandomTargetGenerator() }

    fun gameStart() {
        setGameState(GameState.INPROGRESS)
        targetNumber = randomTargetGenerator.generateRandomTarget()
    }

    private fun setGameState(gameState : GameState){
        this.gameState = gameState
    }
}