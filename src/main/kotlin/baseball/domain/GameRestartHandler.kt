package baseball.domain

class GameRestartHandler {
    fun restart(command: Int?): Boolean {
        when (command) {
            1 -> return true
            2 -> return false
            else -> throw IllegalArgumentException("유효하지 않은 형식입니다.")
        }
    }
}