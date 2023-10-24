package baseball.view

import baseball.util.GameMessage
import java.lang.IllegalArgumentException

object InputValidator {

    fun validateInputLength(input: String) {
        if (input.length != 3) {
            throw IllegalArgumentException(GameMessage.GAME_ERROR_INPUT_LENGTH)
        }
    }

    fun validateInputNumber(input: String) {
        if (input.toIntOrNull() == null || input.contains("0")) {
            throw IllegalArgumentException(GameMessage.GAME_ERROR_INPUT_NUMBER)
        }
    }

    fun validateInputDuplicate(input: String){
        if (input.toSet().size != 3) {
            throw IllegalArgumentException(GameMessage.GAME_ERROR_INPUT_DUPLICATE)
        }
    }
}