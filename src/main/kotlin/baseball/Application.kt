package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var startOrExit = "1"
    while (startOrExit == "1") {
        val answerNumbers = makeRandomNumbers()
        do {
            print("숫자를 입력해주세요 : ")
            val inputNumbers = Console.readLine()
            val strike = strikeCount(answerNumbers, inputNumbers)
            val ball = ballCount(answerNumbers, inputNumbers, strike)
        } while (false)
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        startOrExit = Console.readLine()
    }
}

fun ballCount(answerNumbers: String, inputNumbers: String, strike: Int): Int {
    var numberOfBall = 0
    answerNumbers.forEach { answerNumber ->
        inputNumbers.forEach {
            if (answerNumber == it)
                numberOfBall++
        }
    }
    numberOfBall -= strike
    return numberOfBall
}

fun strikeCount(answerNumbers: String, inputNumbers: String): Int {
    var numberOfStrike = 0
    answerNumbers.forEachIndexed { i, answerNumber ->
        if (answerNumber == inputNumbers[i]) {
            numberOfStrike++
        }
    }
    return numberOfStrike
}

fun makeRandomNumbers(): String {
    var randomNumbers = ""
    while (randomNumbers.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers += randomNumber
        }
    }
    return randomNumbers
}
