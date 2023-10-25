package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun inputCheck(inputNumber: String) {
    if (inputNumber.length != 3) {
        throw IllegalArgumentException ()
    }
}

fun randomNum(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputNum(): MutableList<Int> {
    val user = mutableListOf<Int>()
    print("숫자를 입력해주세요 : ")
    val inputNumber = Console.readLine()!!
    inputCheck(inputNumber)
    for (i in inputNumber) {
        user.add(i.digitToInt())
    }
    return user
}

fun hintResult(computerNum: MutableList<Int>, userNum: MutableList<Int>): Int {
    var strike = 0
    var ball = 0
    var not = 0
        for (i in userNum.indices) {
            if (userNum[i] == computerNum[i]) {
                strike += 1
            } else if (computerNum.contains(userNum[i])) {
                ball += 1
            } else {
                not += 1
            }
        }
        if (strike == 3) {
            println("${strike}스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        } else if (not == 3) {
            println("낫싱")
        } else if (strike == 0 && ball == 0) {
            println("낫싱")
        } else if (strike > 0 && ball == 0) {
            println("${strike}스트라이크")
        } else if (strike == 0 && ball > 0) {
            println("${ball}볼")
        } else println("${ball}볼 ${strike}스트라이크 ")
    return strike
}

fun restartEnd(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choice = Console.readLine()!!.toInt()
    return choice
}

fun playGame() {
    while (true) {
        val computerNum = randomNum()
        while (true) {
            val userNum = inputNum()
            val strike = hintResult(computerNum, userNum)
            if (strike == 3) {
                break
            }
        }
        val userChoice = restartEnd()
        if (userChoice == 1) {
            continue
        } else {
            break
        }
    }
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playGame()
}