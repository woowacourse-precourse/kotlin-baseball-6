package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val player = Player()

    fun createRandomNumber(): List<Int> {
        val randomNumberList = mutableListOf<Int>()

        while (randomNumberList.size < NUMBER_LIST_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(MIN_EACH_NUMBER, MAX_EACH_NUMBER)
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber)
            }
        }
        println(randomNumberList)

        return randomNumberList
    }

    fun convertInputNumberToList(): List<Int> {
        var inputNumber = player.inputNumber()
        val inputNumberList = mutableListOf<Int>()
        var eachNumber: Int

        while (inputNumber > MIN_INPUT_DIVIDE_BY_TEN) {
            eachNumber = inputNumber % NUMBER_OF_INPUT_DIVIDE
            inputNumberList.add(eachNumber)
            inputNumber /= NUMBER_OF_INPUT_DIVIDE
        }
        inputNumberList.reverse()

        return inputNumberList
    }

    fun validateInputNumber(inputNumberList: List<Int>) {
        if (inputNumberList.size != NUMBER_LIST_SIZE) {
            throw IllegalArgumentException(ERROR_INPUT_THREE_DIGITS_ONLY)
        }
        if (inputNumberList.distinct().size != inputNumberList.size) {
            throw IllegalArgumentException(ERROR_NUMBER_DUPLICATION)
        }
        if (inputNumberList.any { it < MIN_EACH_NUMBER || it > MAX_EACH_NUMBER }) {
            throw IllegalArgumentException(ERROR_INPUT_ONE_TO_NINE_ONLY)
        }
    }

    fun checkNumberAndPrintResult(computerRandomNumber: List<Int>, playerInputNumber: List<Int>): Int {
        var strike = MIN_STRIKE
        var ball = MIN_BALL

        for (i in playerInputNumber.indices) {
            if (computerRandomNumber[i] == playerInputNumber[i]) {
                strike++
            } else if (computerRandomNumber.contains(playerInputNumber[i])) {
                ball++
            }
        }
        printResult(strike, ball)

        return strike
    }

    private fun printResult(strike: Int, ball: Int) {
        val result = when {
            strike == MAX_STRIKE -> "$strike$STRIKE\n$END_GAME"
            strike != MIN_STRIKE && ball != MIN_BALL -> "$ball$BALL $strike$STRIKE"
            strike == MIN_STRIKE && ball != MIN_BALL -> "$ball$BALL"
            strike != MIN_STRIKE -> "$strike$STRIKE"
            else -> NOTHING
        }
        println(result)
    }
}