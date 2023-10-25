package baseball.domain

class InputValidator {
    fun validate(input: String): Int {
        if (input.length != 3 || !input.all { it.isDigit() } || input.toSet().size != input.length || input.contains('0')) {
            throw IllegalArgumentException()
        }
        return input.toInt()
    }
}