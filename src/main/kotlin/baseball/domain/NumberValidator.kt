package baseball.domain

class NumberValidator {

    fun validate(input: String) {
        validateLength(input)
        validateFormat(input)
        validateDuplication(input)
    }

    private fun validateLength(input: String) {
        if (input.length != 3) {
            throw IllegalArgumentException("입력한 수가 3자리가 아닙니다.")
        }
    }

    private fun validateFormat(input: String) {
        if (input.contains("""[^123456789]""".toRegex())) {
            throw IllegalArgumentException("유효하지 않은 형식입니다.")
        }
    }

    private fun validateDuplication(input: String) {
        if (input.toCharArray().toSet().size < 3) {
            throw IllegalArgumentException("입력이 중복된 수를 가집니다.")
        }
    }

}