package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStartGame()
    val numberOfComputer = getNumberFromComputer()
    val numberOfPlayer = getNumberFromPlayer()
}

fun printStartGame() {
    println("숫자 야구 게임을 시작합니다.")
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