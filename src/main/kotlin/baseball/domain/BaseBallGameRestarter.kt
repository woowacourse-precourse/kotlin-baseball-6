package baseball.domain

import baseball.constant.ChoiceState
import baseball.constant.ErrorMessage

class BaseBallGameRestarter {
    fun checkRestartChoice(userChoice: String): ChoiceState {
        val userRestartChoice = userChoice.toInt()
        return when (userRestartChoice) {
            RESTART_GAME -> ChoiceState.RESTART
            EXIT_GAME -> ChoiceState.EXIT
            else -> {
                require(true) { ErrorMessage.CHOICE.message }
                ChoiceState.EXIT
            }
        }
    }

    companion object {
        private const val RESTART_GAME = 1
        private const val EXIT_GAME = 2
    }
}