package baseball.model

import baseball.view.InputView

class StringToInt(val input: String) {


    fun StringToIntList():List<Int>{
        val invalidInputException = IllegalArgumentException("잘못된 입력값입니다.")
        val inputNum = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw invalidInputException
        }
        val numList: MutableList<Int> = mutableListOf()
        var remainingNumber = inputNum
        if (remainingNumber != null) {
            while (remainingNumber > 0) {
                val num = remainingNumber % 10
                if ((num !in 1..9) || numList.contains(num)) {
                    throw invalidInputException
                } else {
                    numList.add(num)
                }
                remainingNumber /= 10
            }
        }
        return numList
    }
}