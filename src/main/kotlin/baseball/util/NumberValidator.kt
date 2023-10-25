package baseball.util

import baseball.constant.ErrorMessage


class NumberValidator {
    fun isNumberFormat(userChoice: String) {
        require(userChoice.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER.message }
    }

}