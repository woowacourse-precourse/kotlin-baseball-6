package baseball.model

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUser(): BaseBall {
        val userList = mutableListOf<Int>()
        val input = Console.readLine().toCharArray()
        for (i in input)
            userList.add(i.digitToInt())
        return BaseBall(userList)
    }
}