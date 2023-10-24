package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var gameStatus = 1
    var reStart = 1
    startMessage()

    while (gameStatus == 1) {
        val computer = makeRandomNumber()

        while (reStart == 1) {
            val number = inputNumber()
            var strike = 0
            var ball = 0

            for (i in number.indices) {
                if (number[i] == computer[i]) {
                    strike++
                } else if (computer.contains(number[i])) {
                    ball++
                }
            }
            if (strike == 3) {
                strikeMessage()
                break
            } else {
                scoreMessage(strike, ball)
            }

        }
        val input = Console.readLine().toInt()
        if (input == 1) {
            reStart = 1
        } else if (input == 2) {
            gameStatus = 0
            Console.close()
        } else{
            throw IllegalArgumentException("1이나 2를 쓰세요.")
        }
    }
    Console.close()
}

fun startMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun strikeMessage() {
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

fun scoreMessage(strike: Int, ball: Int) {
    if (strike == 0 && ball == 0) {
        println("낫싱")
    } else if (strike == 0 && ball != 0) {
        println("${ball}볼")
    } else if (strike != 0 && ball == 0) {
        println("${strike}스트라이크")
    } else {
        println("${ball}볼 " + "${strike}스트라이크")
    }
}

fun makeRandomNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val number = Console.readLine()
    checkError(number)
    val myNumber = mutableListOf<Int>()
    for (i in number.indices) {
        myNumber.add(number[i].toString().toInt())
    }
    return myNumber
}

fun checkError(number: String): String {
    if (number.length != 3 || number.toIntOrNull() == null) {
        throw IllegalArgumentException("숫자가 3이 넘어가거나 0입니다.")
    }
    for (i in number.indices) {
        if (number[i] < '1' || number[i] > '9') {
            throw IllegalArgumentException("숫자가 아닙니다.")
        }
    }
    if (number.toSet().size != 3) {
        throw IllegalArgumentException("중복된 수가 있습니다.")
    }
    return number

}