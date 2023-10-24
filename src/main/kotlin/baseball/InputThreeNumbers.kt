package baseball

import camp.nextstep.edu.missionutils.Console
import kotlin.concurrent.thread

fun inputThreeNumbers(): MutableList<Int> {
    var inputList = mutableListOf<Int>()

    print("숫자를 입력해주세요 : ")
    var inputString: String = Console.readLine()

    if (validateString(inputString)) {
        for (char in inputString) {
            inputList.add(char.code - '0'.code)
        }
        validateNumbers(inputList)
        return inputList
    } else {
        throw IllegalArgumentException("input string is not validate")
    }
}

fun isLengthThree(inputString: String): Boolean {
    return if (inputString.length == 3) {
        true
    } else {
//        false
        throw IllegalArgumentException("input's length must be 3, but ${inputString.length}")
    }
}

fun isNumber(inputString: String): Boolean {
    return when (inputString.toIntOrNull()) {
        null -> throw IllegalArgumentException("input string must be integer")
        else -> true
    }
}

fun hasDuplicates(inputList: List<Int>) {
    if (inputList.size != inputList.distinct().size) {
        throw IllegalArgumentException("there is duplicated number")
    }
}

fun hasZero(inputList: List<Int>) {
    if (inputList.contains(0)){
        throw IllegalArgumentException("input numbers must not have 0(zero)")
    }
}

fun validateNumbers(inputList: List<Int>) {
    hasDuplicates(inputList)
    hasZero(inputList)
}

fun validateString(inputString: String): Boolean {
    return if (isNumber(inputString) && isLengthThree(inputString)) {
        true
    } else {
        false
    }
}