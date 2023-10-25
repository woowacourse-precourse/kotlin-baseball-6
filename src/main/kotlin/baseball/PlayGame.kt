package baseball

import baseball.domain.BaseballMatch
import baseball.domain.Computer
import baseball.domain.userChoiceValidation
import baseball.domain.userNumberValidation
import baseball.model.GameState
import baseball.model.MatchResult
import baseball.resources.*
import camp.nextstep.edu.missionutils.Console

class PlayGame(
    private val computer: Computer
) {

    init {
        println(STARTING_COMMENT)
    }

    fun playGame() {
        val computerNumber = computer.generateComputerNumbers()

        while (true) {
            val gameState = round(computerNumber)
            when (gameState) {
                GameState.CONTINUE -> continue
                GameState.RESTART -> {
                    playGame()
                    return
                }
                GameState.EXIT -> {
                    Console.close()
                    return
                }
            }
        }
    }

    private fun round(computerNumber: String): GameState {
        print(ENTER_NUMBER_COMMENT)
        val userNumber = Console.readLine()
        userNumber.userNumberValidation()

        val matchResult = BaseballMatch(computerNumber).matchComputerUserNumber(userNumber)

        return gameStateResult(matchResult)
    }

    private fun gameStateResult(matchResult: MatchResult): GameState {
        return when (matchResult) {
            is MatchResult.Success -> {
                println(matchResult.comment)

                val userChoice = Console.readLine()
                userChoice.userChoiceValidation()

                 when (userChoice) {
                    RESTART_VALUE -> {
                        GameState.RESTART
                    }
                    EXIT_VALUE -> {
                        GameState.EXIT
                    }
                    else -> {
                        GameState.CONTINUE
                    }
                }
            }
            is MatchResult.Fail -> {
                println(matchResult.comment)

                GameState.CONTINUE
            }
        }
    }
}