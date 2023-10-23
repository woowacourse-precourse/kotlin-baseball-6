package baseball

import camp.nextstep.edu.missionutils.Console

class Reader {
    fun read(): String = try {
        Console.readLine()
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }

}