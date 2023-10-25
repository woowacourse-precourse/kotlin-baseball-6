package baseball.domain

import baseball.exception.ThrowIAE
import baseball.view.View

private const val NUMLIST_SIZE = 3
private const val STRING_LENGTH = 3
private const val DIVIDING_NUM = 10
private const val RESTART = 1
private const val FINISH = 2

class Player {
    var numList = mutableListOf<Int>()

    private fun getRestartOrNot(): Int {
        println(View.INPUT_RESTART)
        val input = readlnOrNull()
        val throwIAE = ThrowIAE()
        throwIAE.checkNullOrBlank(input)

        return throwIAE.checkToInt(input!!)
    }

    fun isRestart(): Boolean {
        return when (getRestartOrNot()) {
            RESTART -> true
            FINISH -> false
            else -> throw IllegalArgumentException()
        }
    }

    fun getNumber() {
        numList = mutableListOf()
        print(View.INPUT_NUMBERS)
        val input = readlnOrNull()
        val throwIAE = ThrowIAE()
        throwIAE.checkNullOrBlank(input)
        throwIAE.checkLength(input!!, STRING_LENGTH)
        var intInput = throwIAE.checkToInt(input)

        while (numList.size < NUMLIST_SIZE) {
            val currentNum = intInput % DIVIDING_NUM
            throwIAE.checkNumZero(currentNum)
            throwIAE.checkElemDuplication(numList, currentNum)
            numList.add(currentNum)
            intInput /= DIVIDING_NUM
        }
        numList.reverse()
    }
}