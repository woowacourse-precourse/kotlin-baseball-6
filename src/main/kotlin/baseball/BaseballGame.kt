package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {
    fun playGame() {
        printStartGameMessage()
        do {
            gameRun()
        } while (chooseRestartAndExit())
    }

    private fun printStartGameMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    private fun gameRun() {
        val answer = generateRandomNumber()
        while (true) {
            val userNumber = inputUserNumber()
            val score = compareWithNumber(answer, userNumber)
            printHint(score.first, score.second)
            if (score.first == 3) {
                gameOver()
                return
            }
        }
    }

    private fun generateRandomNumber(): String {
        val computer = mutableListOf<Int>()

        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (randomNumber !in computer) {
                computer.add(randomNumber)
            }
        }

        return computer.joinToString("")
    }

    private fun inputUserNumber(): String {
        print("수를 입력하세요: ")
        val user: String = Console.readLine()

        validateInputUserNumber(user)
        return user
    }

    private fun validateInputUserNumber(userNumber: String) {
        require(userNumber.length == 3) { "3자리가 아닌 입력값입니다." }
        require(userNumber.all { it.isDigit() } && !userNumber.contains("0")) { "숫자가 아닌 입력값이 포함되었습니다." }
        for (x in userNumber) {
            require(userNumber.count { it == x } <= 1) { "중복된 숫자가 있습니다." }
        }
    }
}

private fun compareWithNumber(answer: String, userNumber: String): Pair<Int, Int> {
    var strike = 0
    var ball = 0

    for (idx in userNumber.indices) {
        if (userNumber[idx] == answer[idx]) {
            strike++
            continue
        }
        if (userNumber.contains(answer[idx])) {
            ball++
        }
    }

    return Pair(strike, ball)
}

private fun printHint(strike: Int, ball: Int) {
    val hint = buildHint(strike, ball)
    println(hint)
}

private fun buildHint(strike: Int, ball: Int): String {
    return when {
        ball != 0 && strike != 0 -> "${ball}볼 ${strike}스트라이크"
        ball != 0 -> "${ball}볼"
        strike != 0 -> "${strike}스트라이크"
        else -> "낫싱"
    }
}

private fun gameOver() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

private fun chooseRestartAndExit(): Boolean {
    val flag: Int = Console.readLine().toInt()
    validateRestartAndExit(flag)
    return flag == 1
}

private fun validateRestartAndExit(flag: Int) {
    require(flag in setOf(1, 2)) { "1이나 2가 아닌 다른 입력 값입니다." }
}

