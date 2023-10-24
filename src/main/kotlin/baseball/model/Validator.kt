package baseball.model

object Validator {

    fun validAnswer(input: String) {
        require(input.length == 3) { ErrorType.InvalidLength.message }
        require(input.all { char -> char.isDigit()}) { ErrorType.Duplicated.message}
        require(input.toSet().size == 3) { ErrorType.NotNumeric.message }
        require(input.all { char -> char.digitToInt() in (1..9).toList() }) { ErrorType.OutOfRange.message }
    }

    internal enum class ErrorType(val message: String) {
        InvalidLength("3개의 숫자를 입력해주세요."),
        OutOfRange("각 숫자는 1~9까지의 숫자만 입력 가능합니다."),
        Duplicated("중복되는 숫자는 입력 불가능합니다."),
        NotNumeric("문자는 입력할 수 없습니다.")
    }
}