package baseball

import camp.nextstep.edu.missionutils.Console

class Player {
    fun inputNumber(): List<Int> {
        var inputNumber = Console.readLine().toInt()
        val inputNumberList = mutableListOf<Int>()
        var eachNumber: Int

        while (inputNumber > 0) {
            eachNumber = inputNumber % 10
            inputNumberList.add(eachNumber)
            inputNumber /= 10
        }
        inputNumberList.reverse()

        return inputNumberList
    }
}