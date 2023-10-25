package baseball.model

import baseball.resources.*

enum class GameState(val value: String) {
    CONTINUE(NONE_VALUE), RESTART(RESTART_VALUE), EXIT(EXIT_VALUE)
}