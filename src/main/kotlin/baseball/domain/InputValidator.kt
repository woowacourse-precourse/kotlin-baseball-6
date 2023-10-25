package baseball.domain

class InputValidator {
    fun validate(input: String): Int {
        if (input.length != 3 || !input.all { it.isDigit() }) {
            throw IllegalArgumentException()
        }
        return input.toInt()
    }
}