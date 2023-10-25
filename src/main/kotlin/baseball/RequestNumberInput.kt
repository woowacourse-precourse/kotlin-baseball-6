package baseball

import camp.nextstep.edu.missionutils.Console

fun requestNumberInput(): Array<Char> {
    showGameInfo(InfoMsgType.RequestNumberInput)
    val numberInput: String = Console.readLine()
    if (!isValidNumberInput(numberInput)) {
        throw IllegalArgumentException()
    }
    return numberInput.toCharArray().toTypedArray()
}

fun isValidNumberInput(numberInput: String): Boolean {
    if (numberInput.length != 3) { // 예외1. 자릿수 벗어남
        return false
    } else if (hasNonNumericChar(numberInput)) {// 예외2. 범위를 벗어난 숫자 입력 & 예외3. 문자 특수기호 등 잘못된 입력
        return false
    } else if (hasDuplicatedNumbers(numberInput)) { // 예외4. 중복된 숫자 입력
        return false
    }
    return true
}

fun hasNonNumericChar(input: String): Boolean {
    val convertedInput: List<Int> = input.map { s -> s.code }.toList()
    for (ascii in convertedInput) {
        if (ascii < 49 || ascii > 57) {
            return true
        }
    }
    return false
}

fun hasDuplicatedNumbers(input: String): Boolean {
    if (input.toList().distinct().size != 3) {
        return true
    }
    return false
}