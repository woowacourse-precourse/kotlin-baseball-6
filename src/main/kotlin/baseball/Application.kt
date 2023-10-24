package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val INPUT_RULE = 3
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val INPUT_EXCEPTION = "잘못된 입력입니다."
const val CONTINUE = 0
const val RESTART = 1
const val EXIT = 2
const val GAME_START = "숫자 야구 게임을 시작합니다."
const val NOTHING = "낫싱"
const val BALL = "볼 "
const val STRIKE = "스트라이크 "
const val CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val CORRECT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

fun main() {
    gameStart()
}

private fun gameStart() {
    val computer = mutableListOf<Int>()
    generateMission(computer)
    while (true) {
        print(INPUT_MESSAGE)
        val input = inputCheck()
        val result = scoreMission(computer = computer, user = input)
        when (result) {
            CONTINUE -> {
                continue
            }

            RESTART -> {
                computer.clear()
                generateMission(computer)
            }

            EXIT -> {
                break
            }

            else -> {
                throw IllegalArgumentException(INPUT_EXCEPTION)
            }
        }
    }
}

private fun generateMission(computer: MutableList<Int>) {
    while (computer.size < INPUT_RULE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(GAME_START)
}

private fun inputCheck(): String {
    val input = Console.readLine()
    if (input.length != INPUT_RULE || input.toSet().size != INPUT_RULE) {
        throw IllegalArgumentException(INPUT_EXCEPTION)
    }
    for(item in (input.map { it.toString().toInt() })){
        if (item<=0){
            throw IllegalArgumentException(INPUT_EXCEPTION)
        }
    }
    return input
}

private fun scoreMission(computer: MutableList<Int>, user: String): Int {
    val userInput = user.map { it.toString().toInt() }
    var strike = 0
    var ball = 0

    for (userItem in userInput) {
        if (computer.contains(userItem)) ball++
    }

    for ((userItem, testItem) in computer.withIndex()) {
        if (userInput[userItem] == testItem) {
            strike++
            ball--
        }
    }

    val result = if (strike > 0 || ball > 0) {
        val sb = StringBuilder()
        if (ball > 0) sb.append(ball).append(BALL)
        if (strike > 0) sb.append(strike).append(STRIKE)
        sb.toString()
    } else NOTHING

    println(result)

    return if (strike == 3) {
        println(CORRECT)
        println(CORRECT_MESSAGE)
        Console.readLine().toInt()
    } else {
        CONTINUE
    }
}
