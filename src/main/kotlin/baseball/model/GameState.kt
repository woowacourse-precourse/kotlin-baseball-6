package baseball.model

import baseball.utils.UserChoice.EXIT_VALUE
import baseball.utils.UserChoice.NONE_VALUE
import baseball.utils.UserChoice.RESTART_VALUE

enum class GameState(val value: String) {
    RESTART(RESTART_VALUE), EXIT(EXIT_VALUE), CONTINUE(NONE_VALUE)
}