package baseball

import camp.nextstep.edu.missionutils.Console

object BaseballView {
    fun displayMessage(message: String) {
        println(message)
    }

    fun readInput(message: String): String {
        print(message)
        return Console.readLine()
    }
}