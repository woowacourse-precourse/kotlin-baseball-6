package baseball.view

class InputValidator {
    fun validateNumbersInput(input: String?) {
        if (input == null || !input.matches(Regex("^\\d+$"))) {
            throw IllegalArgumentException("입력은 반드시 숫자로만 이루어져야 합니다.")
        }
    }
}