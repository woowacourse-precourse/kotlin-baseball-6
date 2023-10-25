package baseball.model

import baseball.resources.*

enum class GameState(val value: String) {
    RESTART(RESTART_VALUE), EXIT(EXIT_VALUE), CONTINUE(NONE_VALUE)
}