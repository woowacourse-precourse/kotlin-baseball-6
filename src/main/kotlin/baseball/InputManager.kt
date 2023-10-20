package baseball

import baseball.Constants.EXCEPTION_CHAR
import baseball.Constants.EXCEPTION_SIZE
import baseball.Constants.EXCEPTION_ZERO
import kotlin.IllegalArgumentException

object InputManager {
    fun getNumberList(input: String): MutableList<Int> = try {
        val inputList = input.toMutableList()
        val outputList = mutableListOf<Int>()

        if (inputList.size != 3) throw IllegalArgumentException(EXCEPTION_SIZE)

        inputList.map { numChar ->
            val number = numChar.toString().toInt()
            if (number in 1..9) outputList.add(number)
            else throw IllegalArgumentException(EXCEPTION_ZERO)
        }

        outputList
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(EXCEPTION_CHAR)
    }
}