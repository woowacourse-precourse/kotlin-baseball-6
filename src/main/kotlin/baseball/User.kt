package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    fun getNumberList(): MutableList<Int> {
        val mutableList = mutableListOf<Int>()
        val input = Console.readLine()
        isValidateInputString(input)
        input.forEach { mutableList.add(it.digitToInt()) }
        return mutableList
    }

    fun getFinishNumber(): Int {
        val input = Console.readLine()
        isValidateFinishNumber(input)
        return input.toInt()
    }
}