package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import values.*
import java.lang.StringBuilder
import kotlin.math.E


fun main() {
    val computer = mutableListOf<Int>()
    generateMission(computer)
    while (true) {
        print(INPUT_MESSAGE)
        val input = Console.readLine()
        inputCheck(input)
        val res = scoreMission(computer = computer, user = input)
        when (res) {
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

private fun inputCheck(input: String) {
    if (input.length != INPUT_RULE || input.toSet().size != INPUT_RULE) {
        throw IllegalArgumentException(INPUT_EXCEPTION)
    }
}

private fun scoreMission(computer: MutableList<Int>, user: String): Int {
    val userInput = user.toCharArray().map { Character.getNumericValue(it) }
    var strike = 0
    var ball = 0
    var nothing = 0
    for (userItem in userInput) {
        if (computer.contains(userItem)) ball++
    }
    for ((userItem, testItem) in computer.withIndex()) {
        if (userInput[userItem] == testItem) {
            strike++
            ball--
        }
    }
    if (strike == 0 && ball == 0) nothing = 1
    val sb = StringBuilder()
    if (nothing == 1) {
        sb.append(NOTHING)
    } else {
        if (ball != 0) {
            sb.append(ball).append(BALL)
        }
        if (strike != 0) {
            sb.append(strike).append(STRIKE)
        }
    }
    println(sb)
    return if (strike == 3) {
        println(CORRECT)
        println(CORRECT_MESSAGE)
        Console.readLine().toInt()
    } else {
        CONTINUE
    }
}
