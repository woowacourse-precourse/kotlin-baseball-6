package baseball

import baseball.constants.GameInstruction
import baseball.constants.GameRestartOption
import baseball.constants.GameResult

class BaseBallGame(
    private val gameGuide: GameGuide = GameGuide(),
    private val baseBallCreator: BaseBallCreator = BaseBallCreator(),
    private val player: Player = Player(),
    private val referee: Referee = Referee()
) {
    fun play() {
        gameGuide.show(GameInstruction.GAME_START)
        var restartOption = GameRestartOption.INIT
        while (restartOption != GameRestartOption.EXIT) {
            val answerBaseBalls = baseBallCreator.createAnswerBalls()

            do {
                gameGuide.show(GameInstruction.ENTER_NUMBER)
                val numbers = player.selectNumbers()
                val baseBalls = BaseBallConvertor().convert(numbers)
                val gameResult = referee.determineGameResult(answerBaseBalls, baseBalls)
                gameGuide.show(gameResult)
            } while (answerBaseBalls != baseBalls)

            gameGuide.show(GameResult.WIN)
            gameGuide.show(GameInstruction.RESTART_OR_FINISH)

            restartOption = player.determineRestart()
        }
    }
}