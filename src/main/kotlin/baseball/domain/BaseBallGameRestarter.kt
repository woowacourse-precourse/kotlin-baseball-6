package baseball.domain

import baseball.constant.ChoiceState
import baseball.constant.ErrorMessage

class BaseBallGameRestarter(private val userChoice: Int) {

    init {
        require(isIncorrectRangeChoice(userChoice)) { ErrorMessage.NOT_RESTART_RANGE.message }
    }

    fun checkRestartChoice(): ChoiceState {
        if (userChoice == RESTART_GAME) {
            return ChoiceState.RESTART
        }

        return ChoiceState.EXIT
    }


    private fun isIncorrectRangeChoice(userNumber: Int): Boolean {
        return when (userNumber) {
            in RESTART_GAME..EXIT_GAME -> true
            else -> false
        }
    }

    companion object {
        private const val RESTART_GAME = 1
        private const val EXIT_GAME = 2
    }
}