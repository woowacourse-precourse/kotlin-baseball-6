package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val SIZE = 3

fun main() {
    gameStart()
}

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
    var computerNumber: ArrayList<Int> = answerNumber()
    while (true) {
        val myNumber: ArrayList<Int> = input()
        if (comparisonNumber(myNumber, computerNumber)) {
            if (!reGame()) {
                break
            } else {
                computerNumber = answerNumber()
            }
        }
    }
}

fun input(): ArrayList<Int> {
    print("숫자를 입력해주세요 : ")
    val userNumber = Console.readLine().trim()
    val numberList: ArrayList<Int> = arrayListOf()
    require(!userNumber.contains("0")) {
        "1에서 9사이의 숫자를 입력하세요."
    }
    require(userNumber.length == SIZE) {
        "잘못된 입력입니다. 3개의 숫자를 입력하세요"
    }
    for (i in 0..< SIZE) {
        try {
            numberList.add(userNumber[i].digitToInt())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("잘못된 입력입니다. 숫자를 입력하세요.")
        }
    }
    return numberList
}

fun answerNumber(): ArrayList<Int> {
    val computer: ArrayList<Int> = arrayListOf()
    while (computer.size < SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun comparisonNumber(myNumber: ArrayList<Int>, computerNumber: ArrayList<Int>): Boolean {
    var strike = 0
    var ball = 0
    repeat(SIZE) { index ->
        when {
            myNumber[index] == computerNumber[index] -> strike++
            myNumber[index] in computerNumber -> ball++
        }
    }
    return printResult(ball, strike)
}

fun printResult(ball: Int, strike: Int): Boolean {
    val message = when {
        strike == 3 -> "3스트라이크\n3개의 숫자를 모두 맞혔습니다! 게임 종료"
        strike == 0 && ball == 0 -> "낫싱"
        strike == 0 -> "${ball}볼"
        ball == 0 -> "${strike}스트라이크"
        else -> "${ball}볼 ${strike}스트라이크"
    }

    println(message)
    return strike == 3
}

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