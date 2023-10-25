package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

private var ball = 0
private var strike = 0
private var command = 1
private var computerNumbers = listOf(0, 0, 0)

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (command == 1) {
        generateRandomNumbers()

        while (true) {
            val userInput: List<Int>
            userInput = getUserInput()
            errorInputHandler(userInput)
            compareNumbers(userInput, computerNumbers)

            if (endCheck()) {
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                command = readLine()!!.toInt()
                break
            } else continue
        }

        if (command == 2) return
    }
}

fun generateRandomNumbers() {
    val numbers = mutableSetOf<Int>()

    while (numbers.size < 3) {
        numbers.add(pickNumberInRange(0, 9))
    }

    computerNumbers = numbers.toList()
}

fun getUserInput(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val num = readLine() ?: throw IllegalArgumentException()
    if (num.length != 3) throw IllegalArgumentException()

    return num.map { it.toString().toInt() }
}

fun errorInputHandler(userInput: List<Int>) {
    if (userInput.distinct().size != 3) throw IllegalArgumentException()
}

fun compareNumbers(userInput: List<Int>, computerInput: List<Int>) {
    strike = 0
    ball = 0

    userInput.forEachIndexed { index, number ->
        when {
            number == computerInput[index] -> strike++
            number in computerInput -> ball++
        }
    }
}

fun endCheck(): Boolean {
    return when {
        strike == 3 -> {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            resetGame()
            true
        }
        else -> {
            displayResult()
            resetGame()
            false
        }
    }
}

fun resetGame() {
    ball = 0
    strike = 0
}

fun displayResult() {
    when {
        ball > 0 && strike > 0 -> println("${ball}볼 ${strike}스트라이크")
        ball == 0 && strike > 0 -> println("${strike}스트라이크")
        ball > 0 && strike == 0 -> println("${ball}볼")
        else -> println("낫싱")
    }
}