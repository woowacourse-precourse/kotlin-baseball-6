package baseball

import baseball.utils.Comment.ENTER_NUMBER_COMMENT
import baseball.domain.BaseballMatch
import baseball.domain.Computer
import baseball.domain.User
import baseball.domain.User.userChoiceValidation
import baseball.domain.User.userNumberValidation
import baseball.model.GameState
import baseball.model.MatchResult
import camp.nextstep.edu.missionutils.Console

object PlayGame {

    fun playGame() {
        val baseBallMatch = BaseballMatch(computer = Computer.generateComputerNumbers())

        while (true) {
            val gameState = round(baseBallMatch)
            when(gameState) {
                GameState.RESTART -> {
                    playGame()
                    return
                }
                GameState.EXIT -> return
                GameState.CONTINUE -> continue
            }
        }
    }

    private fun round(baseBallMatch: BaseballMatch): GameState {
        print(ENTER_NUMBER_COMMENT)
        val userNumber = Console.readLine()
        userNumber.userNumberValidation()

        val matchResult = baseBallMatch.matchComputerUserNumber(userNumber)

        return gameStateResult(matchResult)
    }

    private fun gameStateResult(matchResult: MatchResult): GameState {
        return when(matchResult) {
            is MatchResult.Success -> {
                println(matchResult.comment)

                val userChoice = Console.readLine()
                userChoice.userChoiceValidation()

                GameState.entries.find { it.value == userChoice }!!
            }
            is MatchResult.Fail -> {
                println(matchResult.comment)

                GameState.CONTINUE
            }
        }
    }
}