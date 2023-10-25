package baseball.constant

enum class ErrorMessage(val message: String) {
    CHOICE("1 또는 2를 입력해주세요!"),
    INPUT_ZERO("0 입력 오류!"),
    NOT_NUMBER("입력값은 숫자여야 합니다!"),
    NOT_NUMBER_RANGE("세자리 숫자여야 합니다!"),
    NOT_RESTART_RANGE("1 또는 2를 입력해주세요!"),
    NOT_DISTINCT_NUMBER("중복된 숫자는 없습니다!")
}