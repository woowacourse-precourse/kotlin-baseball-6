package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.StringBuilder


const val INPUT_RULE = 3
fun main() {
    val computer = mutableListOf<Int>()
    generateMission(computer)
    while (true) {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        inputCheck(input)
        val res = scoreMission(computer = computer, user = input)
        when (res) {
            0 -> {
                continue
            }

            1 -> {
                computer.clear()
                generateMission(computer)
            }

            2 -> {
                break
            }

            else -> {
                throw IllegalArgumentException("잘못된 입력입니다.")
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
    println("숫자 야구 게임을 시작합니다.")
}

private fun inputCheck(input: String) {
    when {
        input.length != INPUT_RULE -> throw IllegalArgumentException("잘못된 입력입니다.")
        input.toSet().size != INPUT_RULE -> throw IllegalArgumentException("잘못된 입력입니다.")
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
        sb.append("낫싱")
    } else {
        if (ball != 0) {
            sb.append(ball).append("볼 ")
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크 ")
        }
    }
    println(sb)
    return if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        Console.readLine().toInt()
    } else {
        0
    }
}
