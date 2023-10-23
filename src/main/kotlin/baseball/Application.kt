package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val answerNumberList: List<Int> = createAnswerNumber()
    val playerNumberList: List<Int> = getPlayerNumber()

}

fun createAnswerNumber(): List<Int> {
    val numbers = mutableSetOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
    return numbers.toList()
}

fun getPlayerNumber(): List<Int> {
    val receiveValue = Console.readLine().trim()

    if(receiveValue.length != 3) {
        throw IllegalArgumentException("3자리 숫자를 입력해 주세요")
    }
    try {
        receiveValue.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자만 입력해 주세요")
    }
    if(receiveValue.contains("0")) {
        throw IllegalArgumentException("1~9까지의 숫자만 입력해 주세요")
    }
    if(receiveValue.toList().toSet().size != 3) {
        throw IllegalArgumentException("중복된 숫자 입력 불가")
    }
    return receiveValue.toList().map { Character.getNumericValue(it) }
}