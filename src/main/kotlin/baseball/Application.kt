package baseball

import baseball.Constants.CONTINUE_OR_NOT
import baseball.Constants.START
import camp.nextstep.edu.missionutils.Console

fun main() {
    println(START)
    while (true) {
        Player.startGame()
        println(CONTINUE_OR_NOT)
        val input = Console.readLine().toInt()
        if (input == 2) return else if (input == 1) continue
    }
}