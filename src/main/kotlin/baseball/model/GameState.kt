package baseball.model

import baseball.UserChoice.EXIT_VALUE
import baseball.UserChoice.NONE_VALUE
import baseball.UserChoice.RESTART_VALUE

enum class GameState(val value: String) {
    RESTART(RESTART_VALUE), EXIT(EXIT_VALUE), CONTINUE(NONE_VALUE)
}