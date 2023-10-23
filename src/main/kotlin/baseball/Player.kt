package baseball

class Player {

    fun createPlayerBallNumbers(): List<Int> {
        val numbersInput = readln()
        Validation().checkBallNumbersValidity(numbersInput)
        return numbersInput.map { it.toString().toInt() }
    }

    fun getGameEndDecision(): String {
        val userInput = readln()
        Validation().checkPlayerDecisionValidity(userInput)
        return userInput
    }

}