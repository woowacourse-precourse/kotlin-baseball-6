package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStartGame()
    val numberOfComputer = getNumberFromComputer()

    startGame(numberOfComputer)
}

fun printStartGame() {
    println("숫자 야구 게임을 시작합니다.")
}

fun startGame(numberOfComputer: List<String>) {
    var stopFlag = 1

    do {
        val numberOfPlayer = getNumberFromPlayer()

        stopFlag = 0
    } while (stopFlag == 1)
}

fun getNumberFromComputer(): List<String> {
    val randomNumbers = arrayListOf<String>()

    while (randomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }

    return randomNumbers
}

fun getNumberFromPlayer(): List<String> {
    print("숫자를 입력해주세요 : ")

    val randomNumbers = arrayListOf<String>()
    val inputNumber = Console.readLine()

    checkNumberOfPlayer(inputNumber)

    inputNumber.forEach {
        if (randomNumbers.size < 3) {
            val number = it.toString()
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number)
            }
        }
    }

    Console.close()

    return randomNumbers
}

fun checkNumberOfPlayer(numbers: String) {
    numbers.forEach {
        val number = it.code

        if (number < 49 || number > 57) {
            throw IllegalArgumentException()
        }
    }
}