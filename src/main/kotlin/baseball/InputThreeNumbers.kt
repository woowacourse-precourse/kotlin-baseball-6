package baseball

import camp.nextstep.edu.missionutils.Console
import kotlin.concurrent.thread

fun inputThreeNumbers(): MutableList<Int> {
    var inputList = mutableListOf<Int>()

    print("숫자를 입력해주세요 : ")
    var inputString: String = Console.readLine()

    if (validateString(inputString)) {
        for (char in inputString) {
            inputList.add(char.code)
        }
        return inputList
    } else {
        throw IllegalArgumentException("input string is not validate")
    }
}

fun isLengthThree(inputString: String): Boolean {
    return if (inputString.length == 3) {
        true
    } else {
        false
    }
}

fun isNumber(inputString: String): Boolean {
    return when (inputString.toIntOrNull()) {
        null -> false
        else -> true
    }
}

fun validateString(inputString: String): Boolean {
    return if (isNumber(inputString) && isLengthThree(inputString)) {
        true
    } else {
        false
    }
}