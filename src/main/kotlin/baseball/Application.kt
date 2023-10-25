package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import java.util.ArrayList

fun main() {
    playGame()
}

fun playGame() {
    println("숫자 야구 게임을 시작합니다.")
    var randomNumbers = makeRandomNumbers()
    while (true) {
        print("숫자를 입력해주세요 : ")
        val exitGame = getUserInput(randomNumbers)
        if (exitGame) {
            val userInput = readLine()
            if (userInput == "1") {
                randomNumbers = makeRandomNumbers()
            } else if (userInput == "2") {
                println("GAME OVER")
                break
            } else {
                throw IllegalArgumentException("입력값이 유효하지 않습니다. 게임을 종료합니다.")
            }
        }
    }
}

fun getUserInput(randomNumbers: MutableList<Int>): Boolean {
    val userInput = readLine().map { it.digitToInt() }.toMutableList()
    val verifiedInput = validateInput(userInput)
    if (verifiedInput) {
        val gameResult = validateStrikeAndBall(randomNumbers, userInput)
        return printGameResult(gameResult)
    } else {
        throw IllegalArgumentException("입력값이 유효하지 않습니다. 게임을 종료합니다.")
    }
}

fun printGameResult(gameResult: MutableList<Int>): Boolean {
    if (gameResult[0] != 0 && gameResult[1] == 0) {
        println("${gameResult[0]}볼")
    } else if (gameResult[0] == 0 && gameResult[1] != 0) {
        println("${gameResult[1]}스트라이크")
    } else if (gameResult[0] != 0 && gameResult[1] != 0) {
        println("${gameResult[0]}볼 ${gameResult[1]}스트라이크")
    } else {
        println("낫싱")
    }
    if (gameResult[1] == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return true
    }
    return false
}

fun validateStrikeAndBall(randomNumbers: MutableList<Int>, userInput: MutableList<Int>): MutableList<Int> {
    var strike = 0
    var ball = 0
    val result = mutableListOf<Int>()

    for (i in 0..2) {
        for (j in 0..2) {
            if (randomNumbers[i] == userInput[j]) {
                if (i == j) strike += 1
                else ball += 1
            }
        }
    }
    result.add(ball)
    result.add(strike)
    return result
}

fun validateInput(userInput: MutableList<Int>): Boolean {
    val checkedUserInput = userInput.distinct()
    return if (userInput.size != checkedUserInput.size || userInput.size != 3) {
        false
    } else {
        true
    }
}

fun makeRandomNumbers(): MutableList<Int> {
    val randomNumbers = mutableListOf<Int>()
    while (randomNumbers.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }
    return randomNumbers
}



