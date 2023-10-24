package baseball.view

import baseball.domain.Constants
import baseball.domain.player.PlayerNumbers
import baseball.domain.player.PlayerNumber

object InputView {
    fun readNumbers(): PlayerNumbers {
        print("숫자를 입력해주세요: ")
        val input = readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")
        val numbers = try {
            input.chunked(1).map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력값이 숫자가 아닙니다.")
        }

        try {
            return PlayerNumbers(numbers.map { PlayerNumber(it) })
        } catch (e: IllegalArgumentException) {
            when (e.message) {
                Constants.LENGTH_ERROR_MESSAGE -> throw IllegalArgumentException(Constants.LENGTH_ERROR_MESSAGE)
                Constants.DUPLICATED_ERROR_MESSAGE -> throw IllegalArgumentException(Constants.DUPLICATED_ERROR_MESSAGE)
                else -> throw e
            }
        }
    }
}
