package baseball.util


class NumberValidator {
    fun isNumberFormat(userChoice: String): Boolean {
        return userChoice.all { char -> char.isDigit() }
    }

}