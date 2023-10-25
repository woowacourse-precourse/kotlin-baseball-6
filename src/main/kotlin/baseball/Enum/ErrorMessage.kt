package baseball

enum class ErrorMessage(val eMessage: String) {
    LENGTH_OVER_THREE("3자리 이상을 입력하였습니다."),
    WRONG_NUMBER("수를 잘못 입력하였습니다."),
    DUPLICATE_NUMBER("중복된 숫자를 입력하셨습니다."),
    LENGTH_OVER_ONE("1자리 이상을 입력하였습니다.")
}