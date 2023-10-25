package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var playAgain = true

    println("숫자 야구 게임을 시작합니다.")

    while (playAgain) {
        playGame()
        print("게임을 새로 시작하려면 1, 종료하려면 2을 입력하세요: ")
        val input = Console.readLine()
        if (input == "2") {
            playAgain = false
        }
    }

    println("게임 종료!")
}

fun playGame() {

}

fun generateComputerNumbers(): List<Int> {
    return List(3) { Randoms.pickNumberInRange(1, 9) }
}

fun getUserInput(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    if (input == null || input.length != 3 || input.any { it !in '1'..'9' }) {
        throw IllegalArgumentException("잘못된 입력입니다.")
    }
    return input.map { it.toString().toInt() }
}

