package baseball

import camp.nextstep.edu.missionutils.Console

class User() {
    fun readNumbers(): String = Console.readLine()

    fun reGame(): Boolean {
        return when (Console.readLine()) {
            RE_GAME -> true
            END_GAME -> false
            else -> throw IllegalArgumentException(INVALID_NUMBER)
        }
    }

    companion object {
        private const val RE_GAME = "2"
        private const val END_GAME = "1"
        private const val INVALID_NUMBER = "유효한 수가 아닙니다."
    }
}