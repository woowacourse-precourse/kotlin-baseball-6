package baseball

class GameManager {
    lateinit var targetNumber: List<Int>
        private set

    private val randomTargetGenerator: RandomTargetGenerator by lazy { RandomTargetGenerator() }

    fun gameStart() {
        targetNumber = randomTargetGenerator.generateRandomTarget()
    }
}