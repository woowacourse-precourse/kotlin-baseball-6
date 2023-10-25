package baseball.domain

import baseball.constant.ChoiceState
import baseball.constant.ErrorMessage

class BaseBallGameRestarter(private val userChoice: Int) {

    init {
        require(isIncorrectRangeChoice(userChoice)) { ErrorMessage.NOT_RESTART_RANGE.message }
    }

    fun checkRestartChoice(): ChoiceState {
        return when (userChoice) {
            RESTART_GAME -> ChoiceState.RESTART
            EXIT_GAME -> ChoiceState.EXIT
            else -> {
                require(false) { ErrorMessage.CHOICE.message }
                ChoiceState.EXIT
            }
        }
    }


    private fun isIncorrectRangeChoice(userNumber: Int): Boolean {
        return when (userNumber) {
            in RESTART_GAME..EXIT_GAME -> false
            else -> true
        }
    }

    companion object {
        private const val RESTART_GAME = 1
        private const val EXIT_GAME = 2
    }
}