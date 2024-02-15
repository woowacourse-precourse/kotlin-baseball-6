package baseball.validate

class InputValidator {
    companion object {

         fun validateInputNumberSize(inputNumbers: String, numberSize: Int) {
            if (inputNumbers.length != numberSize) {
                throw IllegalArgumentException("숫자는 ${numberSize}자리를 입력해주세요")
            }
        }

    }
}