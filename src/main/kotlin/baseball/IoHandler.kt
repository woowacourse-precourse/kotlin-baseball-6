package baseball

import camp.nextstep.edu.missionutils.Console

class IoHandler {
    private val regex = Regex("\\b[0-9]{3}\\b")

    fun getInput(): String? {
        val input = Console.readLine()
        if (regex.matches(input).not()) {
            throw IllegalArgumentException()
        }
        return input
    }

    fun print(msg: String) {
        println(msg)
    }
}