package baseball

import camp.nextstep.edu.missionutils.Randoms


fun userInput(): List<Int> {
    var userNumber = mutableListOf<Int>()
    print("숫자를 입력해주세요 : ")
    val inputLine = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    if (inputLine.length == 3 && inputLine.all { item -> item.isDigit() }) {
        userNumber = inputLine.map { it.toString().toInt() }.toMutableList()
    } else {
        throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    }
    return userNumber
}

fun runBaseBallGame() {
//    숫자 랜덤 생성
    val baseballNumbers = mutableListOf<Int>()
    while (baseballNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!baseballNumbers.contains(randomNumber)) {
            baseballNumbers.add(randomNumber)
        }
    }
//    유저 입력 받는 부분
//    TODO 반복문으로 개조 필요
    val userNumber = userInput()
}


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    runBaseBallGame()
}
