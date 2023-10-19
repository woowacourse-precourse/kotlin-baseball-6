package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    private var userNumber = mutableListOf<Int>()
    fun inputNumber(): MutableList<Int> {
        val inputNumber = Console.readLine()
        if (inputNumber.length != 3)
            throw IllegalArgumentException()
        userNumber.clear()
        for (char in inputNumber) {
            val digit = char.toString().toIntOrNull()
            if (digit != null) {
                userNumber.add(digit)
            }
        }
        if(userNumber.size!=3)
            throw IllegalArgumentException()
        return userNumber
    }
}