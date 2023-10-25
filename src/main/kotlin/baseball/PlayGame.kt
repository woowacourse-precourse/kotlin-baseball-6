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
        val baseBallMatch = BaseballMatch(computer = computer.generateComputerNumbers())

        while (true) {
            val gameState = round(baseBallMatch)
            when (gameState) {
                GameState.RESTART -> {
                    playGame()
                    return
                }

                GameState.EXIT -> {
                    Console.close()
                    return
                }
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
        return when (matchResult) {
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