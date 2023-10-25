package baseball

import baseball.ErrorMessage.BOUND_ERROR
import baseball.ErrorMessage.DUPLICATE_ERROR
import baseball.ErrorMessage.FORMAT_ERROR
import baseball.ErrorMessage.SIZE_ERROR
import baseball.GameMessage.INPUT_MESSAGE
import baseball.NumberBounds.END_NUMBER
import baseball.NumberBounds.MAX_SIZE
import baseball.NumberBounds.START_NUMBER
import camp.nextstep.edu.missionutils.Console

class UserInput : NumberProvider {

    override fun getNumberList(): List<Int> {
        try {
            print(INPUT_MESSAGE)
            return Console.readLine().map { it.toString().toInt() }
                .apply { validate(this) }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(FORMAT_ERROR)
        } catch (e: IllegalArgumentException) {
            throw e
        }
    }

    private fun validate(userInput: List<Int>) {
        validateNumberLength(userInput)
        validateNumberInRange(userInput)
        validateNumberDuplicate(userInput)
    }

    private fun validateNumberDuplicate(userInput: List<Int>) {
        if (userInput.size != userInput.toSet().size) {
            throw IllegalArgumentException(DUPLICATE_ERROR)
        }
    }

    private fun validateNumberInRange(userInput: List<Int>) {
        userInput.forEach {
            if (it < START_NUMBER || it > END_NUMBER) {
                throw IllegalArgumentException(BOUND_ERROR)
            }
        }
    }

    private fun validateNumberLength(userInput: List<Int>) {
        if (userInput.size != MAX_SIZE) {
            throw IllegalArgumentException(SIZE_ERROR)
        }
    }
}
