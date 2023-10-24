package baseball

import baseball.utils.RandomNumberGenerator
import baseball.utils.containsDuplicatedNumber
import baseball.utils.isInt
import baseball.utils.isRangeOf
import camp.nextstep.edu.missionutils.Console

class Game {

    private fun checkAnswerInput(input: String) {
        if (input.length != 3) {
            throwIllegalException()
        }

        if (!input.isInt(includeSign = false)) {
            throwIllegalException()
        }

        if (input.containsDuplicatedNumber()) {
            throwIllegalException()
        }

        if (input.isRangeOf(1, 9)) {
            throwIllegalException()
        }
    }

    private fun checkNextGameAnswer(input: String){
        if (input == "1" || input == "2") {
            return
        }
        throwIllegalException()
    }

    private fun throwIllegalException() {
        throw IllegalArgumentException("입력 값이 올바르지 않음")
    }
}