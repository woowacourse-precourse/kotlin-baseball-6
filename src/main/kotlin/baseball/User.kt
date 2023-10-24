package baseball

import camp.nextstep.edu.missionutils.Console

class User() {
    fun readNumbers(): String = Console.readLine()

    fun reGame(): Boolean {
        return when (Console.readLine()) {
            "2" -> true
            "1" -> false
            else -> throw IllegalArgumentException("유효한 수가 아닙니다.")
        }
    }
}