package baseball.util

import baseball.util.GameValue.PLAYER_MAX_NUMBER
import baseball.util.GameValue.PLAYER_NIM_NUMBER

object Validator {
    fun check(value: String) {
        duplicatesCheck(value)
    }

    private fun duplicatesCheck(value: String) {
        val originLength = value.length
        val checkLength = value.toSet()
        if (originLength != checkLength.size) {
            throw IllegalArgumentException()
        }
        lengthCheck(value)
    }

    private fun lengthCheck(value: String) {
        if (value.length != GameValue.GAME_NUMBER_LENGTH) {
            throw IllegalArgumentException()
        }
        formatCheck(value)
    }

    private fun formatCheck(value: String) {
        value.forEach {
            if (it !in PLAYER_NIM_NUMBER..PLAYER_MAX_NUMBER) {
                throw IllegalArgumentException()
            }
        }
    }
}