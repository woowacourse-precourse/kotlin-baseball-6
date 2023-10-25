package baseball

import camp.nextstep.edu.missionutils.Console

object Player {
    private val playerNumbers = mutableListOf<Int>()

    fun inputNumber() {
        val inputPlayerNumber = Console.readLine()
        ExceptionHandler.checkPlayerInput(inputPlayerNumber)
        setNumber(inputPlayerNumber)
    }

    fun inputRestartOrEnd() {
        val inputPlayerNumber = Console.readLine().toInt()
        ExceptionHandler.checkPlayerInputIsRestartOrFinish(inputPlayerNumber)
    }

    private fun setNumber(inputNum: String) {
        playerNumbers.clear()
        inputNum.forEach { number ->
            playerNumbers.add(Character.getNumericValue(number))
        }
    }

    fun getNumber() = playerNumbers

}