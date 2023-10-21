package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStartGame()
    val numberOfComputer = getNumberFromComputer()
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