package baseball.Util

enum class Exception(private val message: String) {
    INVALID_NUMBER_LENGTH("사용자의 입력이 3자리수가 아닙니다."),
    INVALID_INTEGER("사용자의 입력이 정수가 아닙니다."),
    INVALID_RANGE("사용자의 입력 중 범위를 벗어난 자릿수가 존재합니다."),
    INVALID_UNIQUE("사용자의 입력 중 중복된 자릿수가 존재합니다."),
    INVALID_GAME_STATUS_NUMBER("사용자의 입력이 1 또는 2가 아닙니다.");

    fun getMessage() = message
}