package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

const val INPUT_SIZE = 3
const val NO_INPUT = 0
var exit : Boolean = false

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    exit = false
    while (!exit) {
        startGame()
        restartOrExit()
    }
}

fun startGame() {
    val computer = generateRandomComputerNumber()
    Baseball().run(computer)
}

fun generateRandomComputerNumber() : List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < INPUT_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computer.contains(randomNumber)) computer.add(randomNumber)
    }
    return computer
}

fun restartOrExit() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val inputNumber = readln()
    exit = when(inputNumber) {
        "" -> throw NullPointerException("값을 입력하지 않았습니다. 프로그램 종료합니다.")
        "1" -> false
        "2" -> {
            println("프로그램을 종료합니다")
            true
        }
        else -> throw IllegalArgumentException("잘못된 값을 입력했습니다. 프로그램 종료합니다.")
    }
}
