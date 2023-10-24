package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf


fun main() {
    var isRestartGame = true
    while (isRestartGame) {
        // 3자리 랜덤 숫자 생성
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        var is3strike = false
        println("숫자 야구 게임을 시작합니다.")
        while (!is3strike) {
            print("숫자를 입력해주세요 : ")
            val num = readNumber(Console.readLine(), false)
            is3strike = evaluateGuess(num, computer)
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val restartNum = readNumber(Console.readLine(), true)
        if (restartNum == 2) {
            isRestartGame = false
        }
    }
}

// 입력 유효성 확인
fun readNumber(num: String, isRestart: Boolean): Int {
    try {
        val validNum = num.toInt()
        if (isRestart && validNum != 1 && validNum != 2) {
            throw IllegalArgumentException()
        } else if (!isRestart && (num.length != 3 || num[0] == num[1] || num[1] == num[2] || num[0] == num[2]) || num.contains(
                "0"
            )
        ) {
            throw IllegalArgumentException()
        }
        return validNum
    } catch (e: Exception) {
        if (isRestart) throw IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        else throw IllegalArgumentException("1-9까지의 공백 없이 서로 다른 3자리 숫자를 입력해주세요.")
    }
}

// 입력 점수 확인
fun evaluateGuess(num: Int, computer: MutableList<Int>): Boolean {
    val first = num / 100
    val second = (num / 10) % 10
    val third = num % 10

    var strike = 0
    var ball = 0

    if (first == computer[0]) strike++
    else if (first == computer[1] || first == computer[2]) ball++
    if (second == computer[1]) strike++
    else if (second == computer[0] || second == computer[2]) ball++
    if (third == computer[2]) strike++
    else if (third == computer[1] || third == computer[0]) ball++

    val output = when {
        strike == 3 -> {
            "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        }

        strike == 0 && ball == 0 -> "낫싱"
        strike == 0 -> "${ball}볼"
        ball == 0 -> "${strike}스트라이크"
        else -> "${ball}볼 ${strike}스트라이크"
    }

    println(output)
    return strike == 3
}