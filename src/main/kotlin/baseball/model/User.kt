package baseball.model

import baseball.BASEBALL_MAX_SIZE
import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUser(): BaseBall {
        val userList = mutableListOf<Int>()
        val input = Console.readLine().toCharArray()

        checkNumber(input)
        checkSize(input)
        checkRepeat(input)

        for (i in input)
            userList.add(i.digitToInt())
        return BaseBall(userList)
    }

    private fun checkNumber(input: CharArray) {
        input.forEach {
            if (it !in '1'..'9') {
                throw IllegalArgumentException()
            }
        }
    }

    private fun checkSize(input: CharArray) {
        if (input.size != BASEBALL_MAX_SIZE) {
            throw IllegalArgumentException()
        }
    }

    private fun checkRepeat(input: CharArray) {
        if (input.size != input.distinct().count()) {
            throw IllegalArgumentException()
        }
    }
}