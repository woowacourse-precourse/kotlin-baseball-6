package baseball.model

import baseball.model.BaseballNumber.Companion.END_NUMBER
import baseball.model.BaseballNumber.Companion.START_NUMBER
import baseball.model.BaseballNumbers.Companion.NUMBERS_DIGIT
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class RandomAnswerGenerator : AnswerGenerator {
    override fun generate(): BaseballNumbers {
        val numbers = mutableSetOf<BaseballNumber>()
        while (numbers.size < NUMBERS_DIGIT) {
            numbers.add(BaseballNumber(pickNumberInRange(START_NUMBER, END_NUMBER)))
        }
        return BaseballNumbers(numbers.toList())
    }
}