package baseball.config


object GameMsg {
    const val START_GAME = "숫자 야구 게임을 시작합니다."
    const val ENTER_NUMBER = "숫자를 입력해주세요: "
    const val GAME_OVER = """${GameNumberConfig.DIGIT_NUMBER}개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 ${GameCommandConfig.RESTART_CMD}, 종료하려면 ${GameCommandConfig.EXIT_CMD}를 입력하세요."""
    const val NOTING = "낫싱"
    const val STRIKE = "스트라이크"
    const val BALL = "볼"
}

object ExceptionMsg {
    const val INVALID_FORMAT = "유효하지 않은 형식입니다"
    const val WRONG_DIGIT_COUNT = "입력한 수가 ${GameNumberConfig.DIGIT_NUMBER}자리가 아닙니다."
    const val DUPLICATE_INPUT = "입력이 중복된 수를 가집니다."
}


