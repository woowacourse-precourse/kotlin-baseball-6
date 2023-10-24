package baseball.model

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUser(): BaseBall {
        val userList = mutableListOf<Int>()
        val input = Console.readLine().toCharArray()

        checkNumber(input)

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
}