package baseball

import camp.nextstep.edu.missionutils.Console

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
