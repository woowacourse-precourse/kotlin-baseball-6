package baseball.controller

import baseball.model.BaseballNumber
import baseball.model.BaseballNumber.Companion.START_NUMBER
import baseball.model.BaseballNumbers
import baseball.model.BaseballNumbers.Companion.NUMBERS_DIGIT
import baseball.view.Command
import baseball.view.InputView.Companion.COMMAND_PROMPT


fun Int.toBaseballNumbers(): BaseballNumbers {
    require(this >= START_NUMBER) {
        INVALID_NUMBERS
    }

    var tempNumber = this
    val numbers = mutableListOf<BaseballNumber>()
    while (tempNumber > 0) {
        val digit = tempNumber % 10
        numbers.add(0, BaseballNumber(digit))
        tempNumber /= 10
    }
    return BaseballNumbers(numbers)
}

fun Int.toCommand(): Command {
    val command = Command.entries.firstOrNull { it.command == this }
    require(command != null) {
        INVALID_COMMAND
    }
    return command
}

const val INVALID_NUMBERS = "0 이상의 $NUMBERS_DIGIT 자리 수를 입력해주세요."
val INVALID_COMMAND = "잘못된 입력입니다.\n $COMMAND_PROMPT"
