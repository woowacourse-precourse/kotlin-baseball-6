package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val player = Player()

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

    fun convertInputNumberToList(): List<Int> {
        var inputNumber = player.inputNumber()
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

    fun validateInputNumber(inputNumberList: List<Int>) {
        if (inputNumberList.size != 3) {
            throw IllegalArgumentException(ERROR_INPUT_THREE_DIGITS_ONLY)
        }
        if (inputNumberList.distinct().size != inputNumberList.size) {
            throw IllegalArgumentException(ERROR_NUMBER_DUPLICATION)
        }
        if (inputNumberList.any { it < 1 || it > 9 }) {
            throw IllegalArgumentException(ERROR_INPUT_ONE_TO_NINE_ONLY)
        }
    }

    fun checkNumberAndPrintResult(computerRandomNumber: List<Int>, playerInputNumber: List<Int>): Int {
        var strike = 0
        var ball = 0

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
            strike == 3 -> "$strike$STRIKE\n$END_GAME"
            strike != 0 && ball != 0 -> "$ball$BALL $strike$STRIKE"
            strike == 0 && ball != 0 -> "$ball$BALL"
            strike != 0 -> "$strike$STRIKE"
            else -> NOTHING
        }
        println(result)
    }
}