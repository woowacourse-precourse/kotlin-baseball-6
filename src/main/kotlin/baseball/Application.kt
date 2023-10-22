package baseball

import baseball.constants.GameInstruction
import baseball.constants.GameRestartOption
import baseball.constants.GameResult

fun main() {
    var restartOption = GameRestartOption.INIT
    val gameGuide = GameGuide()
    val baseBallCreator = BaseBallCreator()
    val player = Player()
    val referee = Referee()

    gameGuide.show(GameInstruction.GAME_START)
    // baseballGame class 로 리팩?? baseballGame.play()
    while (restartOption != GameRestartOption.EXIT) {
        val answerBaseBalls = baseBallCreator.createAnswerBalls()
        // round class 로 리팩?? round.start()
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
