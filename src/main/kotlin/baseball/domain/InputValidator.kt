package baseball.domain

class InputValidator {
    fun validate(input: String): Int {
        if (input.length != 3 || !input.all { it.isDigit() } || input.toSet().size != input.length) {
            throw IllegalArgumentException()
        }
        return input.toInt()
    }
}