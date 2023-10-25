package baseball.model.validator

@JvmInline
internal value class AnswerValidation(private val input: String) {

    fun assertValidLength(): AnswerValidation =
        assertAndContinue(input.length == 3, ErrorType.InvalidLength)

    fun assertNumeric(): AnswerValidation =
        assertAndContinue(input.all { char -> char.isDigit()}, ErrorType.NotNumeric)

    fun assertNotDuplicated(): AnswerValidation =
        assertAndContinue(input.toSet().size == 3, ErrorType.Duplicated)

    fun assertInOfRange(): AnswerValidation =
        assertAndContinue(input.all { char -> char.digitToInt() in (1..9).toList() }, ErrorType.OutOfRange)

    private fun AnswerValidation.assertAndContinue(boolean: Boolean, error: ErrorType? = null): AnswerValidation {
        require(boolean) { error?.message ?: "오류" }
        return this
    }

    internal enum class ErrorType(val message: String) {
        InvalidLength("3개의 숫자를 입력해주세요."),
        OutOfRange("각 숫자는 1~9까지의 숫자만 입력 가능합니다."),
        Duplicated("중복되는 숫자는 입력 불가능합니다."),
        NotNumeric("문자는 입력할 수 없습니다."),
    }
}