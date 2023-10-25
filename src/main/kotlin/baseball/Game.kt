package baseball

import baseball.GameUtils.countBall
import baseball.GameUtils.countStrike
import baseball.GameUtils.isAnswer
import baseball.GameUtils.trialResultMessage
import baseball.ValidateUtils.validateDigit
import baseball.ValidateUtils.validateDigitRange
import baseball.ValidateUtils.validateDuplicateNumber
import baseball.ValidateUtils.validateLength
import camp.nextstep.edu.missionutils.Console

class Game {
    private val computer = Computer()
    private val player = Player()
    private var gameState = GameState.END

    fun start() {
        println(START_GAME_MESSAGE)
        gameState = GameState.PLAYING
        computer.generateAnswer()
        while (gameState == GameState.PLAYING) {
            val input = player.trial()
            verify(input)

            if (gameState == GameState.END) {
                println(RESTART_GAME_MESSAGE)
                val restartState = Console.readLine()
                when (restartState) {
                    INPUT_RESTART_STATE -> restart()
                    INPUT_ENDGAME_STATE -> return
                    else -> throw IllegalArgumentException()
                }
            }
        }
    }

    private fun reset() {
        computer.resetAnswer()
    }

    private fun restart() {
        reset()
        start()
    }

    private fun verify(input: String) {
        validInputCheck(input)
        trialResult(input)
    }

    private fun validInputCheck(input: String) {
        validateLength(input)
        validateDigit(input)
        validateDigitRange(input)
        validateDuplicateNumber(input)
    }

    private fun trialResult(input: String) {
        val strikeCount = countStrike(computer.answer, input)
        val ballCount = countBall(computer.answer, input)
        val resultMessage = trialResultMessage(strikeCount, ballCount)
        println(resultMessage)

        if (isAnswer(strikeCount)) {
            println(GAME_RESULT_ANSWER_MESSAGE)
            gameState = GameState.END
        }
        return
    }
}

enum class GameState {
    PLAYING, END, ERROR
}