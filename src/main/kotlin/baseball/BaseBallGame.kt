package baseball

import baseball.constants.GameInstruction
import baseball.constants.GameRestartOption
import baseball.constants.GameResult

class BaseBallGame(
    private val gameGuide: GameGuide = GameGuide(),
    private val baseBallCreator: BaseBallCreator = BaseBallCreator(),
    private val player: Player = Player(),
    private val referee: Referee = Referee(),
) {
    fun start() {
        gameGuide.show(GameInstruction.GAME_START)
        var restartOption = GameRestartOption.INIT
        while (restartOption != GameRestartOption.EXIT) {
            cycleRound(answerBaseBalls = baseBallCreator.createAnswerBalls())
            restartOption = requireRestartOption()
        }
    }

    private fun cycleRound(answerBaseBalls: List<Int>) {
        do {
            val result = Round(
                player = player,
                referee = referee,
                answerBaseBalls = answerBaseBalls,
            ).run()
        } while (isWin(result).not())
        gameGuide.show(GameResult.WIN)
    }

    private fun requireRestartOption(): GameRestartOption {
        gameGuide.show(GameInstruction.RESTART_OR_FINISH)
        return player.determineRestart()
    }

    private fun isWin(result: String): Boolean {
        return result == WIN_RESULT
    }

    companion object {
        private const val WIN_RESULT = "3스트라이크"
    }
}