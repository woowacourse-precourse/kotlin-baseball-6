package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {

    val numberSet: MutableSet<String> = mutableSetOf()
    var playGame = true

    println("숫자 야구 게임을 시작합니다.")
    while (playGame) {
        getRandomNumber(numberSet)
        while (true) {
            print("숫자를 입력해주세요 : ")
            val input = getUserNumber()
            val result = checkGame(input, numberSet)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
        playGame = getUserChoice()
    }
}

fun getRandomNumber(numberSet: MutableSet<String>) {
    numberSet.clear()
    while (numberSet.size < 3) {
        val number = pickNumberInRange(1, 9)
        if (number.toString() !in numberSet) {
            numberSet.add(number.toString())
        }
    }
}

fun getUserNumber(): String {
    while (true) {
        val input = Console.readLine()
        if (input.length == 3) {
            return input
        } else {
            throw IllegalArgumentException("잘못된 입력값입니다.")
        }
    }
}

fun getUserChoice(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choice = Console.readLine().toInt()
    return choice == 1
}

fun checkGame(input: String, numberSet: MutableSet<String>): String {
    val inputIndex = input.toList().map { it.toString() }
    val strike = inputIndex.zip(numberSet).count { (inputIndex, targetIndex) -> inputIndex == targetIndex }
    val ball = inputIndex.count { it in numberSet } - strike

    return when {
        strike == 3 -> "3스트라이크"
        strike > 0 || ball > 0 -> "${ball}볼 ${strike}스트라이크"
        else -> "낫싱"
    }
}