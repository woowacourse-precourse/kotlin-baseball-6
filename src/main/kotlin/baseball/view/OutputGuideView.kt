package baseball.view

import baseball.config.GameCommandConfig
import baseball.config.GameNumberConfig

class OutputGuideView {
    fun showStartMsg() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun showEndMsg() {
        println(
            """${GameNumberConfig.DIGIT_NUMBER}개의 숫자를 모두 맞히셨습니다! 게임 종료
                |게임을 새로 시작하려면 ${GameCommandConfig.RESTART_CMD}, 종료하려면 ${GameCommandConfig.EXIT_CMD}를 입력하세요.
            """.trimMargin()
        )
    }
}