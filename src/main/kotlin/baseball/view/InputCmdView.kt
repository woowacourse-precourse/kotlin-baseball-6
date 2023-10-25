package baseball.view

import baseball.config.ExceptionMsg.INVALID_FORMAT
import baseball.config.GameCommandConfig
import camp.nextstep.edu.missionutils.Console

class InputCmdView {
    operator fun invoke(): Boolean {
        return when (Console.readLine()) {
            GameCommandConfig.RESTART_CMD -> true
            GameCommandConfig.EXIT_CMD -> false
            else -> throw IllegalArgumentException(INVALID_FORMAT)
        }
    }
}