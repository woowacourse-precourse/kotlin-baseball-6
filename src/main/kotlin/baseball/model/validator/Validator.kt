package baseball.model.validator

object Validator {

    fun validAnswer(input: String) {
        AnswerValidation(input)
            .assertValidLength()
            .assertNumeric()
            .assertNotDuplicated()
            .assertInOfRange()
    }

    fun validExitInput(input: String) {
        require(input == "1" || input == "2") { ErrorType.InvalidExitInput }
    }

    internal enum class ErrorType(val message: String) {
        InvalidExitInput("1 또는 2만 입력할 수 있습니다.")
    }
}