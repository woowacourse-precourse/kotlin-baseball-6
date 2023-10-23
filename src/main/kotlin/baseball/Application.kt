package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    baseballGame()
}

fun baseballGame(): Unit {
    var restartGame = true
    while (restartGame) {
        // 매 게임의 타겟 숫자 3개 선택
        var randomNumbers = mutableListOf<Int>()
        for (i in 0..2) {
            randomNumbers.add(Randoms.pickNumberInRange(1, 9))
        }
        inputNumbers(randomNumbers)

        // 게임 종료
        restartGame = inputRestart()
    }
}

fun inputNumbers(target: List<Int>): Unit {
    var strike: Int = 0
    var ball: Int = 0
    while (strike != 3) {
        print("숫자를 입력해주세요: ")
        val inputNumbers = Console.readLine()
        // 입력 예외처리
        if (inputNumbers.length != 3) {
            throw IllegalArgumentException("길이가 3이 아닌 입력 발생")
        }
        if (inputNumbers.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자가 아닌 입력 발생")
        }

        val result = checkNumbers(target, inputNumbers)
        strike = result[0]
        ball = result[1]

        outputResult(strike, ball)
    }
}

fun checkNumbers(target: List<Int>, inputString: String): List<Int> {
    var strike = 0
    var ball = 0

    for (i in 0..2) {
        val check = inputString[i].digitToInt()
        if (check == target[i]) {
            strike++
        } else if (check in target) {
            ball++
        }
    }

    return listOf(strike, ball)
}

fun outputResult(strike: Int, ball: Int): Unit {
    if (strike == 3) {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임종료")
    } else if (strike == 0 && ball != 0) {
        println("${ball}볼")
    } else if (strike != 0 && ball == 0) {
        println("${strike}스트라이크")
    } else if (strike != 0 && ball != 0) {
        println("${ball}볼 ${strike}스트라이크")
    } else {
        println("낫싱")
    }
}

fun inputRestart(): Boolean {
    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ")
    val inputAfterGameOver = Console.readLine()
    if (inputAfterGameOver != "1" && inputAfterGameOver != "2") {
        throw IllegalArgumentException("1, 2 이외의 다른 입력 발생")
    }

    val gameRestartOption = inputAfterGameOver.toInt()
    if (gameRestartOption == 1) {
        return true
    }
    return false
}
