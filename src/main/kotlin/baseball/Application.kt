package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val answerNumberList = createAnswerNumber()

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