package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    fun createRandomNumber(): List<Int> {
        val randomNumberList = mutableListOf<Int>()
        while (randomNumberList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber)
            }
        }
        println(randomNumberList)
        return randomNumberList
    }

    private fun convertInputNumberToList(): List<Int> {
        var inputNumber = Player().inputNumber()
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

    fun validateInputNumber() {
        val convertInputNumberList = convertInputNumberToList()

        if (convertInputNumberList.size != 3) {
            throw IllegalArgumentException(ERROR_INPUT_THREE_DIGITS_ONLY)
        }
        if (convertInputNumberList.distinct().size != convertInputNumberList.size) {
            throw IllegalArgumentException(ERROR_NUMBER_DUPLICATION)
        }
        if (convertInputNumberList.any { it < 1 || it > 9 }) {
            throw IllegalArgumentException(ERROR_INPUT_ONE_TO_NINE_ONLY)
        }
    }
}