package baseball.controller

import baseball.model.BaseballNumber
import baseball.model.BaseballNumber.Companion.START_NUMBER
import baseball.model.BaseballNumbers
import baseball.model.BaseballNumbers.Companion.NUMBERS_DIGIT

class NumbersConverter {
    fun toBaseballNumbers(number: Int): BaseballNumbers {
        require(number >= START_NUMBER) {
            INVALID_NUMBERS
        }

        var tempNumber = number
        val numbers = mutableListOf<BaseballNumber>()
        while (tempNumber > 0) {
            val digit = tempNumber % 10
            numbers.add(0, BaseballNumber(digit))
            tempNumber /= 10
        }
        return BaseballNumbers(numbers)
    }

    companion object {
        const val INVALID_NUMBERS = "0 이상의 $NUMBERS_DIGIT 자리 수를 입력해주세요."
    }
}