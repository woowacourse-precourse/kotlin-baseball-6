package baseball.validcheck

class Exceptions() {
    fun inputNumberException(input: String) {
        when {
            input.toSet().size < 3 -> throw IllegalArgumentException("중복된 수입니다.")
            input.length > 3 -> throw IllegalArgumentException("3자리 수만 입력해주세요")
            isNotNumber(input) -> throw IllegalArgumentException("0을 제외한 숫자만 입력해 주세요")
        }
    }

    private fun isNotNumber(input: String) = !("[1-9]{3}".toRegex()
        .matches(input))
}