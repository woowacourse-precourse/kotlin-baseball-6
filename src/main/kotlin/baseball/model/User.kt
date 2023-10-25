package baseball.model

import baseball.BASEBALL_MAX_SIZE
import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUser(): MutableList<Int> {
        val userList = mutableListOf<Int>()
        val input = Console.readLine().toCharArray()

        checkNumber(input)
        checkSize(input)
        checkRepeat(input)

        for (i in input) {
            userList.add(i.digitToInt())
        }
        return userList
    }

    private fun checkNumber(input: CharArray) {
        require(input.all { it in '1'..'9' })
    }

    private fun checkSize(input: CharArray) {
        require(input.size == BASEBALL_MAX_SIZE)
    }

    private fun checkRepeat(input: CharArray) {
        require(input.size == input.distinct().count())
    }
}