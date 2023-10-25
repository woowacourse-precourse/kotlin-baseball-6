package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var playAgain = true
    while (playAgain) {
        val computerNumbers = generateComputerNumbers()
        var attempts = 0

        while (true) {
            print("숫자를 입력해주세요 : ")
            val userGuess = readUserInput()

            val result = checkGuess(userGuess, computerNumbers)
            println(result)

            attempts++

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }

        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
        val choice = readUserInput()
        playAgain = choice == "1"

        if (playAgain) {
            println("새로운 게임을 시작합니다.")
        } else {
            println("게임을 종료합니다.")
        }
    }
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

fun readUserInput(): String {
    return Console.readLine()
}

fun checkGuess(userGuess: String, computerNumbers: List<Int>): String {
    // Validate user input
    if (userGuess.length != 3 || userGuess.toSet().size != 3 || !userGuess.all { it.isDigit() }) {
        throw IllegalArgumentException("잘못된 입력입니다.")
    }

    val userNumbers = userGuess.map { it.toString().toInt() }
    val strikes = computerNumbers.zip(userNumbers).count { (a, b) -> a == b }
    val intersectionSize = userNumbers.intersect(computerNumbers).size
    val balls = intersectionSize - strikes

    if (strikes == 3) {
        return "3스트라이크"
    } else if (strikes > 0 || balls > 0) {
        val result = mutableListOf<String>()
        if (balls > 0) {
            result.add("${balls}볼")
        }
        if (strikes > 0) {
            result.add("${strikes}스트라이크")
        }
        return result.joinToString(" ")
    } else {
        return "낫싱"
    }
}

