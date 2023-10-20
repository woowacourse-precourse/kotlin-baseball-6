package baseball

import camp.nextstep.edu.missionutils.Console

object Player {
    private val playerNumbers = mutableListOf<Int>()

    fun inputNumber() {
        val inputPlayerNumber = Console.readLine()
        ExceptionCheck.checkPlayerInput(inputPlayerNumber)
        setNumber(inputPlayerNumber)
    }

    private fun setNumber(inputNum : String) {
        inputNum.forEach { number ->
            playerNumbers.add(Character.getNumericValue(number))
        }
    }

    fun getNum() {
        for(i in playerNumbers.indices) {
            println(playerNumbers[i])
        }
    }

}