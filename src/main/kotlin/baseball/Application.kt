package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        val answerNumbers = makeRandomNumbers()
        do {
            print("숫자를 입력해주세요 : ")
            val inputNumbers = validInputNumbers()
            val fail = printResult(answerNumbers, inputNumbers)
        } while (fail)
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    } while (validStartOrExit() == "1")
}

fun validStartOrExit(): String {
    val startOrExit = Console.readLine()
    if (startOrExit.length != 1)
        throw IllegalArgumentException("1자리 숫자를 입력하세요.")
    startOrExit.forEach {
        if (it !in '1'..'2')
            throw IllegalArgumentException("숫자 1 혹은 2 를 입력하세요.")
    }
    return startOrExit
}

fun validInputNumbers(): String {
    val inputNumbers = Console.readLine()
    if (inputNumbers.length != 3)
        throw IllegalArgumentException("3자리 숫자를 입력하세요.")
    inputNumbers.forEach {
        if (it !in '1'..'9')
            throw IllegalArgumentException("1 ~ 9 범위의 숫자를 입력하세요.")
    }
    if (inputNumbers.length != inputNumbers.toList().distinct().size)
        throw IllegalArgumentException("서로 다른 숫자를 입력하세요.")
    return inputNumbers
}

fun printResult(answerNumbers: String, inputNumbers: String): Boolean {
    val strike = strikeCount(answerNumbers, inputNumbers)
    val ball = ballCount(answerNumbers, inputNumbers, strike)
    if (strike == 0 && ball == 0) {
        println("낫싱")
    } else if (strike != 0) {
        if (ball != 0) {
            print("${ball}볼 ")
        }
        println("${strike}스트라이크")
    } else {
        println("${ball}볼")
    }
    return when (strike) {
        3 -> false
        else -> true
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
