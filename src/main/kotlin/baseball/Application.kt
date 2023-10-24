// Application.kt
package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        val computer = generateComputerNumbers()
        playGame(computer)
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ")
    } while (Console.readLine() == "1")
}

fun generateComputerNumbers(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun playGame(computer: List<Int>) {
    while (true) {
        print("숫자를 입력해주세요 : ")
        val userGuess = Console.readLine().orEmpty().map { it.toString().toInt() }
        if (userGuess.size != 3) throw IllegalArgumentException()

        val result = evaluateGuess(computer, userGuess)
        if (result == "3스트라이크") {
            println(result)
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        }
        println(result)
    }
}

fun evaluateGuess(computer: List<Int>, userGuess: List<Int>): String {
    var strikes = 0
    var balls = 0

    for (i in userGuess.indices) {
        if (userGuess[i] == computer[i]) {
            strikes++
        } else if (computer.contains(userGuess[i])) {
            balls++
        }
    }

    if (strikes == 0 && balls == 0) return "낫싱"
    return "${if (balls > 0) "${balls}볼 " else ""}${if (strikes > 0) "${strikes}스트라이크" else ""}".trim()
}
