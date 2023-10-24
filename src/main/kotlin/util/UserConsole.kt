package util

import camp.nextstep.edu.missionutils.Console

object UserConsole {
    fun getValidInput(): MutableList<Int> {
        print(Constants.INPUT_MESSAGE)
        val userInput = Console.readLine()
        validateInput(userInput)
        val userNumberList = mutableListOf<Int>()
        userInput.forEach {
            userNumberList.add(it.digitToInt())
        }
        return userNumberList
    }

    private fun validateInput(userInput: String) {
        if (!userInput.all { it.isDigit() }) throw IllegalArgumentException(Constants.INVALID_INPUT_MESSAGE)
        if (userInput.length != 3) throw IllegalArgumentException(Constants.INVALID_LENGTH_MESSAGE)
        if (userInput.toSet().size != userInput.length) throw IllegalArgumentException(Constants.DUPLICATE_NUMBER_MESSAGE)
    }

    fun getValidRestartInput(): String {
        val userInput = Console.readLine()
        if (userInput != "1" && userInput != "2") throw IllegalArgumentException(Constants.INVALID_RESTART_INPUT_MESSAGE)
        return userInput
    }
}