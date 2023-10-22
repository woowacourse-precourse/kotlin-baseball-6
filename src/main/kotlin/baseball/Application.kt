package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {

    val numberSet: MutableSet<Int> = mutableSetOf()
    var playGame = true

    println("숫자 야구 게임을 시작합니다.")
    while (playGame) {
        getRandomNumber(numberSet)
        while (true) {
            print("숫자를 입력해주세요 : ")
            val input = getUserNumber()
            val result = checkGame(input, numberSet)
            println(result)

            if (result == "3 스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val choice = Console.readLine()!!.toInt()
        if (choice != 1) {
            playGame = false
        }
    }
}

fun getRandomNumber(numberSet: MutableSet<Int>) {
    numberSet.clear()
    while (numberSet.size < 3) {
        val number = pickNumberInRange(1, 9)
        if (number !in numberSet) {
            numberSet.add(number)
        }
    }
}

fun getUserNumber(): Int {
    while (true) {
        val input = Console.readLine()
        if (input.length == 3) {
            try {
                return input.toInt()
            } catch (e: NumberFormatException) {
                println("숫자가 아닌 입력입니다. 다시 시도하세요.")
            }
        } else {
            throw IllegalArgumentException("잘못된 입력값입니다.")
        }
    }
}

fun checkGame(input: Int, numberSet: MutableSet<Int>): String {
    val inputIndex = input.toString().toList().map { it.toString().toInt() }
    val strike = inputIndex.zip(numberSet).count { (inputIndex, targetIndex) -> inputIndex == targetIndex }
    val ball = inputIndex.count { it in numberSet } - strike

    return when {
        strike == 3 -> "3 스트라이크"
        strike > 0 || ball > 0 -> "$strike 스트라이크 $ball 볼"
        else -> "낫싱"
    }
}