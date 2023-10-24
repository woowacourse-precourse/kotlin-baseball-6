package baseball

import camp.nextstep.edu.missionutils.Randoms

val SIZE = 3

/**
 * 유저 입력 부분 추가
 * @return 유저한테 입력 받은 수 리턴
 */
fun userInput(): List<Int> {
    var userNumber = mutableListOf<Int>()
    print("숫자를 입력해주세요 : ")
    val inputLine = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    if (inputLine.length == SIZE && inputLine.all { item -> item.isDigit() }) {
        userNumber = inputLine.map { it.toString().toInt() }.toMutableList()
    } else {
        throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    }
    return userNumber
}

/**
 * 유저가 입력한 수로부터 볼과 스트라이크가 몇개나 되는지 확인 후 출력
 * @param baseballNumbers   컴퓨터가 생성한 야구 숫자 번호
 * @param userNumber        유저가 입력한 숫자
 * @return                  계속할건지의 여부
 */
fun answerUserQuestion(baseballNumbers: List<Int>, userNumber: List<Int>): Boolean {
    var strike = 0
    var ball = 0
    val sb = StringBuilder()
    userNumber.forEachIndexed { index, item ->
        if (baseballNumbers[index] == item) {
            strike += 1
        } else if (baseballNumbers.contains(item)) {
            ball += 1
        }
    }
    if (strike > 0 || ball > 0) {
        if (ball > 0) {
            sb.append("${ball}볼 ")
        }
        if (strike > 0) {
            sb.append("${strike}스트라이크 ")
        }
    } else {
        sb.append("낫싱")
    }
    println(sb.toString())
    if (strike == SIZE) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return false
    }
    return true
}

/**
 * 무작위 랜덤 숫자 3개 생성
 */
fun makeRandomNumber(): MutableList<Int> {
    val baseballNumbers = mutableListOf<Int>()
    while (baseballNumbers.size < SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!baseballNumbers.contains(randomNumber)) {
            baseballNumbers.add(randomNumber)
        }
    }
    return baseballNumbers
}

fun runBaseBallGame() {
//    숫자 랜덤 생성
    val baseballNumbers = makeRandomNumber()
//    유저 입력 받는 부분
    do {
        val userNumber = userInput()
        val continueGame = answerUserQuestion(baseballNumbers, userNumber)
    } while (continueGame)
}


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    runBaseBallGame()
}
