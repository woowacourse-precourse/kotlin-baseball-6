package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import java.lang.NumberFormatException

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        printResult()
    }while (printResult() != 2)
    return

}

private fun makeRandomNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    //println(computer)
    return computer
}

private fun guessNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")

    val input = Console.readLine()

    return checkInput(input)
}

private fun checkInput(input: String): MutableList<Int> {
    val inputArray = mutableListOf<Int>()

    try {
        if (input.length == 3) {
            val digit1 = input[0].toString().toInt()
            val digit2 = input[1].toString().toInt()
            val digit3 = input[2].toString().toInt()

            if (digit1 != digit2 && digit1 != digit3 && digit2 != digit3) {
                inputArray.add(digit1)
                inputArray.add(digit2)
                inputArray.add(digit3)

                return inputArray

            } else {
                throw IllegalArgumentException("숫자가 중복되었습니다")
            }
        } else {
            throw IllegalArgumentException("세자리 수가 아닙니다")
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자가 아닙니다")
    }
}

private fun printResult(): Int {
    var strike = 0
    var ball: Int
    val computer = makeRandomNumber()

    while (strike != 3) {
        val inputArray = guessNumber()
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

    return gameOver()
}

private fun gameOver(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return Console.readLine().toInt()
}
