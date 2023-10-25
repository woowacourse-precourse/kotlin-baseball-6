package baseball

class GameManager: ResultListener {
    private val inputManager = InputManager()
    private val player: Player = Player(inputManager)
    private val computer: Computer = Computer(inputManager)

    fun startGame() = Referee(computer.generateValidAnswer(), player.inputNum(), this)

    override fun restartGame() {
        val exitCode: Int = inputManager.input("게임을 새로 시작하려면 ${ONE}, 종료하려면 ${TWO}를 입력하세요.\n", Digit.ONE)
        when(exitCode) {
            ONE -> startGame()
            TWO -> return
        }
    }

    companion object ExitCode {
        const val ONE: Int = 1
        const val TWO: Int = 2
    }
}