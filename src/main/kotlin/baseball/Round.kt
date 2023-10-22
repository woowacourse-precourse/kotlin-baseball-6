package baseball

import baseball.constants.GameInstruction

class Round(
    private val gameGuide: GameGuide = GameGuide(),
    private val player: Player,
    private val referee: Referee,
    private val answerBaseBalls: List<Int>
) {
    fun run(): String {
        gameGuide.show(GameInstruction.ENTER_NUMBER)
        val numbers = player.selectNumbers()
        val baseBalls = BaseBallConvertor().convert(numbers)
        val gameResult = referee.determineGameResult(answerBaseBalls, baseBalls)
        gameGuide.show(gameResult)
        return gameResult
    }
}