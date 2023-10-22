package baseball

import baseball.Comment.ENTER_NUMBER_COMMENT
import baseball.User.userChoiceValidation
import baseball.User.userNumberValidation
import baseball.model.GameState
import baseball.model.MatchResult

object PlayGame {

    fun playGame() {
        val baseBallMatch = BaseballMatch(computer = Computer.generateComputerNumbers())

        while (true) {
            val gameState = round(baseBallMatch)
            when(gameState) {
                GameState.RESTART -> playGame()
                GameState.EXIT -> return
                GameState.CONTINUE -> continue
            }
        }
    }

    private fun round(baseBallMatch: BaseballMatch): GameState {
        print(ENTER_NUMBER_COMMENT)
        val userNumber = User.enterUserNumbers()
        userNumber.userNumberValidation()

        val matchResult = baseBallMatch.matchComputerUserNumber(userNumber)

        return when(matchResult) {
            MatchResult.SUCCEED -> {
                val userChoice = User.enterUserNumbers()
                userChoice.userChoiceValidation()

                GameState.entries.find { it.value == userChoice }!!
            }
            MatchResult.FAIL -> GameState.CONTINUE
        }
    }
}