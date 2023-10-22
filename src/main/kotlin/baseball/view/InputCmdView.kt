package baseball.view

import baseball.config.GameCommandConfig
import camp.nextstep.edu.missionutils.Console

class InputCmdView {
    operator fun invoke(): Boolean {
        return when (Console.readLine()) {
            GameCommandConfig.RESTART_CMD -> true
            GameCommandConfig.EXIT_CMD -> false
            else -> throw IllegalArgumentException("유효하지 않은 형식입니다.")
        }
    }
}