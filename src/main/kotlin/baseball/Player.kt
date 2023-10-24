package baseball

import camp.nextstep.edu.missionutils.Console

class Player {
    fun inputNumber(): Int {
        return try {
            Console.readLine().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_INPUT_NUMBER_ONLY)
        }
    }

    fun inputContinueGameOrNot(): Int {
        return try {
            Console.readLine().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_INPUT_ONE_OR_TWO_ONLY)
        }
    }
}