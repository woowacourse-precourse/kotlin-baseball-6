package baseball.view


import baseball.domain.Constants
import baseball.domain.player.PlayerNumbers
import baseball.domain.player.PlayerNumber

object InputView {
    fun readNumbers(): PlayerNumbers {
        print(Constants.INPUT_MESSAGE)
        val input = readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        val numbers = try {
            input.chunked(1).map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Constants.NOT_NUMBER_ERROR_MESSAGE)
        }
        return PlayerNumbers(numbers.map { PlayerNumber(it) })
    }
}
