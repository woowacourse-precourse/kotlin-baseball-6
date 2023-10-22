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

    fun gameStart() {
        setGameState(GameState.INPROGRESS)
        targetNumber = randomTargetGenerator.generateRandomTarget()
    }

    fun calculateStrikeBall(playerInput : List<Int>){

    }

    private fun setGameState(gameState : GameState){
        this.gameState = gameState
    }
}