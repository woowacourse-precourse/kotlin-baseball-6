package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/**
 * 숫자의 SIZE
 */
const val SIZE: Int = 3

/**
 * 애플리케이션 실행하는 Main 함수
 */
fun main() {
    gameStart()
}

/**
 * 숫자 야구 게임을 실행 하는 함수
 */
fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
    var computerNumber: List<Int> = answerNumber()

    while (true) {
        val myNumber: List<Int> = input()
        println(computerNumber)
        if (comparisonNumber(myNumber, computerNumber)) {
            if (!reGame()) {
                break
            } else {
                computerNumber = answerNumber()
            }
        }
    }
}

/**
 * 사용자에게 숫자를 입력 받는 함수
 */
fun input(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val userNumber = Console.readLine().trim()

    require(userNumber.matches(Regex("[1-9]{3}"))) {
        "1에서 9 사이의 3개의 숫자를 입력하세요."
    }

    return userNumber.map {
        it.toString().toInt()
    }
}

/**
 * 정답 숫자를 생성하는 함수
 */
fun answerNumber(): List<Int> {
    val computer = mutableListOf<Int>()

    while (computer.size < SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

/**
 * 입력 숫자와 정답 숫자를 비교하는 함수
 */
fun comparisonNumber(myNumberList: List<Int>, computerNumberList: List<Int>): Boolean {
    var strike = 0
    var ball = 0

    repeat(SIZE) { index ->
        when {
            myNumberList[index] == computerNumberList[index] -> strike++
            myNumberList[index] in computerNumberList -> ball++
        }
    }

    return printResult(ball, strike)
}

/**
 * 결과를 출력하는 함수
 */
fun printResult(ball: Int, strike: Int): Boolean {
    val message = when {
        strike == SIZE -> "3스트라이크\n${SIZE}개의 숫자를 모두 맞혔습니다! 게임 종료"
        strike == 0 && ball == 0 -> "낫싱"
        strike == 0 -> "${ball}볼"
        ball == 0 -> "${strike}스트라이크"
        else -> "${ball}볼 ${strike}스트라이크"
    }

    println(message)
    return strike == 3
}

/**
 * 정답을 맞춘 후 게임을 재시작 할 것인지 결정하는 함수
 */
fun reGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choice = Console.readLine().toInt()
    return when (choice) {
        1 -> true
        2 -> false
        else -> {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }
}