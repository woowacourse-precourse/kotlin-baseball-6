package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    val game = BaseballGame()
    game.startGame()
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    if (Console.readLine() == "1") {
        val game = BaseballGame()
        game.startGame()
    } else if (Console.readLine() == "2") {}
    else throw IllegalArgumentException("1과 2을 입력해주세요.")
}