package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val GAME_START = "숫자 야구 게임을 시작합니다."
const val INPUT_NUMBER = "숫자를 입력해주세요 : "
const val GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val RESTART_OR_FINISH = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val NOTHING = "낫싱"
var strike: Int = 0
var ball: Int = 0
var restartOrFinish: Int? = null
fun main() {

    val numbers = getRandomNum()

    println(GAME_START)

    while (true) {
        print(INPUT_NUMBER)

        val input = Console.readLine()
        if (input.length != 3) {
            validateInput()
        }

        val inputNumbers = input.map {
            it.toString().toInt()
        }

        calculateCount(inputNumbers, numbers)

        printCount()
        if (strike == 3) {
            println(GAME_OVER)
            println(RESTART_OR_FINISH)
            restartOrFinish = Console.readLine().toInt()
            if (restartOrFinish != 1 && restartOrFinish != 2) {
                validateInput()
            }
        }
        if (restartOrFinish == 2) {
            break;
        }
        initCount()
    }

}

fun validateInput() {
    throw IllegalArgumentException()
}

fun printCount() {
    if (strike == 0 && ball == 0) {
        println(NOTHING)
    } else {
        println("${ball}볼 ${strike}스트라이크")
    }
}

fun calculateCount(inputNumbers: List<Int>, numbers: List<Int>) {
    for (index in inputNumbers.indices) {
        if (numbers[index] == inputNumbers[index]) {
            strike++
        }
    }

    for (num in inputNumbers) {
        if (num in numbers && (inputNumbers.indexOf(num) != numbers.indexOf(num))) {
            ball++
        }
    }
}

fun initCount() {
    strike = 0
    ball = 0
}

fun getRandomNum(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
