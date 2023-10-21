package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    fun selectNumbers(): String {
        val numbers = try {
            Console.readLine()
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
        return numbers
    }
}