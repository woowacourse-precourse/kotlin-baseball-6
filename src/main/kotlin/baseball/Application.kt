package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

val computer = mutableListOf<Int>()
val inputArray = mutableListOf<Int>()
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    printResult()
}

private fun makeRandomNumber() {
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    //println(computer)
}

private fun guessNumber() {
    print("숫자를 입력해주세요 : ")

    val input = readln()
    try {
        if (input.length == 3) {
            val digit1 = input[0].toString().toInt()
            val digit2 = input[1].toString().toInt()
            val digit3 = input[2].toString().toInt()

            if (digit1 != digit2 && digit1 != digit3 && digit2 != digit3) {
                inputArray.add(digit1)
                inputArray.add(digit2)
                inputArray.add(digit3)
            } else {
                throw IllegalArgumentException("게임 종료")
            }
            //println(inputArray)
        } else {
            throw IllegalArgumentException("게임 종료")
        }
    } catch (_: IllegalArgumentException) {
        exitProcess(0)
    }
}

private fun printResult() {
    var strike = 0
    var ball: Int
    makeRandomNumber()
    while (strike != 3) {
        guessNumber()
        strike = 0
        ball = 0

        for (i in inputArray.indices) {
            if (computer[i] == inputArray[i]) {
                strike += 1
            } else if (computer.contains(inputArray[i])) {
                ball += 1
            }
        }

        if (ball > 0 && strike > 0) {
            println("$ball" + "볼" + " $strike" + "스트라이크")
        } else if (ball == 0 && strike != 0) {
            println("$strike" + "스트라이크")
        } else if (strike == 0 && ball != 0) {
            println("$ball" + "볼")
        } else {
            println("낫싱")
        }
        inputArray.clear()
    }

    computer.clear()

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    val gameOver: Int = readln().toInt()

    if (gameOver == 1) {
        main()
    } else if (gameOver == 2) {
        exitProcess(0)
    }
}
