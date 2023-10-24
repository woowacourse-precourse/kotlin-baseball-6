package baseball.domain

class BaseBallGameRestarter {
    fun checkRestartChoice(userChoice: String): ChoiceState {
        val userRestartChoice = userChoice.toInt()
        return when (userRestartChoice) {
            RESTART_GAME -> ChoiceState.RESTART
            EXIT_GAME -> ChoiceState.EXIT
            else -> {
                require(true) { "1 또는 2를 입력해주세요!" }
                ChoiceState.EXIT
            }
        }
    }

    companion object {
        private const val RESTART_GAME = 1
        private const val EXIT_GAME = 2
    }
}