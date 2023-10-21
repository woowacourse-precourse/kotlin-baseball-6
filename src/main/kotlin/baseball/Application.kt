package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStart()
}

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
    var computerNumber: ArrayList<Int> = answerNumber()
    while (true) {
        val myNumber: ArrayList<Int> = input()
        println(myNumber)
        println(computerNumber)
        if (!comparisonNumber(myNumber, computerNumber)) {
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
    val number = readln()
    val numberList: ArrayList<Int> = arrayListOf()
    if (number.length != 3) {
        throw IllegalArgumentException("잘못된 입력입니다. 3개의 숫자를 입력하세요")
    }
    try {
        for (i in 0..2) {
            numberList.add(number[i].digitToInt())
        }
        return numberList
    } catch (e: IllegalArgumentException) {
        throw e
    }
}

fun answerNumber(): ArrayList<Int> {
    val computer: ArrayList<Int> = arrayListOf()
    while (computer.size < 3) {
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
    repeat(3) { index ->
        repeat(3) {
            if (computerNumber[index] == myNumber[it] && index == it) {
                strike++
            } else if (computerNumber[index] == myNumber[it] && index != it)
                ball++
        }
    }
    return printResult(ball, strike)
}

fun printResult(ball: Int, strike: Int): Boolean {
    when {
        strike == 3 -> {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히였습니다! 게임 종료")
            return false
        }

        strike + ball == 0 -> {
            println("낫싱")
            return true
        }

        strike == 0 -> {
            println("${ball}볼")
            return true
        }

        ball == 0 -> {
            println("${strike}스트라이크")
            return true
        }

        else -> {
            println("${ball}볼 ${strike}스트라이크")
            return true
        }
    }
}

fun reGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choice = readln().toInt()
    return when (choice) {
        1 -> true
        2 -> false
        else -> {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }
}