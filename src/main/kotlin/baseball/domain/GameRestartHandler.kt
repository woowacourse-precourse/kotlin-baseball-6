package baseball.domain

import baseball.config.GameCommandConfig.EXIT_CMD
import baseball.config.GameCommandConfig.RESTART_CMD

class GameRestartHandler {
    fun restart(command: String): Boolean {
        return when (command) {
            RESTART_CMD -> true
            EXIT_CMD -> false
            else -> throw IllegalArgumentException("유효하지 않은 형식입니다.")
        }
    }
}