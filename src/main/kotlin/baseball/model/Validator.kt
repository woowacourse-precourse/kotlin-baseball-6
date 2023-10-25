package baseball.model

object Validator {

    fun validAnswer(input: String) {
        require(input.length == 3) { ErrorType.InvalidLength.message }
        require(input.all { char -> char.isDigit()}) { ErrorType.NotNumeric.message}
        require(input.toSet().size == 3) { ErrorType.Duplicated.message }
        require(input.all { char -> char.digitToInt() in (1..9).toList() }) { ErrorType.OutOfRange.message }
    }

    fun validExitInput(input: String) {
        require(input == "1" || input == "2") {}
    }

    internal enum class ErrorType(val message: String) {
        InvalidLength("3개의 숫자를 입력해주세요."),
        OutOfRange("각 숫자는 1~9까지의 숫자만 입력 가능합니다."),
        Duplicated("중복되는 숫자는 입력 불가능합니다."),
        NotNumeric("문자는 입력할 수 없습니다."),
        InvalidExitInput("1 또는 2만 입력할 수 있습니다.")
    }
}