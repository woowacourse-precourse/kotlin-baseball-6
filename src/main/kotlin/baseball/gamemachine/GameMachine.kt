package baseball.gamemachine

import baseball.io.Output

class GameMachine(
    private val printer: Output = Output(),
    private val baseballGame: BaseballGame = BaseballGame()
) {
    init {
        printer.printStartMessage()
    }

    fun startGame() {
        baseballGame.startGame()
    }

}