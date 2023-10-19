package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf

val computer = mutableListOf<Int>()
var is3strike: Boolean = false
fun main() {
    // 3자리 랜덤 숫자 생성
    // computer[0]은 첫번째 자리 [2]는 세번째 자리
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    println("숫자 야구 게임을 시작합니다.")
    while (!is3strike) {
        print("숫자를 입력해주세요 : ")
        val num = readNumber(Console.readLine())
        evaluateGuess(num)
    }
}

// 입력 유효성 확인
fun readNumber(num: String): Int {
    try {
        val validNum = num.toInt()
        if (num.length != 3) {
            throw IllegalArgumentException("숫자는 3자리여야 합니다. ")
        }
        return validNum
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자를 입력해 주세요")
    }
}

fun evaluateGuess(num: Int) {
    val first: Int = num / 100
    val second: Int = (num / 10) % 10
    val third: Int = num % 10
    var strike = 0
    var ball = 0

    if (first == computer[0]) strike++
    else if (first == computer[1] || first == computer[2]) ball++
    if (second == computer[1]) strike++
    else if (second == computer[0] || second == computer[2]) ball++
    if (third == computer[2]) strike++
    else if (third == computer[1] || third == computer[0]) ball++

    val output: String = when {
        strike == 3 -> {
            is3strike = true
            "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        }

        strike == 0 && ball == 0 -> "낫싱"
        strike == 0 -> "${ball}볼"
        ball == 0 -> "${strike}스트라이크"
        else -> "${ball}볼 ${strike}스트라이크"
    }

    println(output)
}