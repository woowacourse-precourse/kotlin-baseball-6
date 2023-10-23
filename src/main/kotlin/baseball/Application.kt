package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

fun main() {
    while (true) {
        println("숫자 야구 게임을 시작합니다.")
        val computerNum = getRandomNum()

        do {
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine()
            val inputNum = setUserNum(input)
        } while (compareNumbers(computerNum, inputNum))

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        if (Console.readLine().toInt() == 2) {
            println("게임을 종료합니다!")
            break
        }
    }

}

fun getRandomNum(): List<Int> {
    val numList: MutableList<Int> = mutableListOf()
    while (numList.size < 3) {
        val randomNum = Randoms.pickNumberInRange(1, 9)
        if (!numList.contains(randomNum)) {
            numList.add(randomNum)
        }
    }
    return numList.toList()
}

fun setUserNum(input: String): List<Int> {
    val invalidInputException = IllegalArgumentException("잘못된 입력값입니다.")
    val inputNum = try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw invalidInputException
    }
    val numList: MutableList<Int> = mutableListOf()
    var remainingNumber = inputNum

    while (remainingNumber > 0) {
        val num = remainingNumber % 10
        if ((num !in 1..9) || numList.contains(num)) {
            throw invalidInputException
        } else {
            numList.add(num)
        }
        remainingNumber /= 10
    }
    if (numList.size != 3) {
        throw invalidInputException
    }
    return numList.reversed().toList()
}

fun compareNumbers(computerList: List<Int>, userList: List<Int>): Boolean {
    var strike = 0
    var ball = 0
    for (userIdx in userList.indices) {
        val userNum = userList[userIdx]
        val comIdx = computerList.indexOf(userNum)
        if (comIdx != -1) {
            if (comIdx == userIdx) {
                strike += 1
            } else {
                ball += 1
            }
        }
    }
    printHint(strike, ball)
    return strike != 3
}

fun printHint(strike: Int, ball: Int) {
    if (strike == 0 && ball == 0) {
        println("낫싱")
    } else {
        if (ball > 0) {
            print("${ball}볼 ")
        }
        if (strike > 0) {
            print("${strike}스트라이크 ")
            if (strike == 3) {
                print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            }
        }
        println()
    }
}