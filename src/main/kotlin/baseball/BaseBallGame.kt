package baseball

class BaseBallGame {
    private val LENGTH = 3
    private val computer: Computer = Computer()
    private val person: Person = Person()
    private val baseBallGameMessage : BaseBallGameMessage = BaseBallGameMessage()

    fun gamePlay() {
        computer.makeComputerNumber()
        baseBallGameMessage.printStartMessage()
        while(true) {
            baseBallGameMessage.printPersonInputMessage()
            person.inputNumber()
            try {
                isValidInput(person.getInputList())
            } catch (e: IllegalArgumentException) {
                break
            }
            val(strike, ball) = calCount(person.getInputList(), computer.getNumberList())
            baseBallGameMessage.printCountMessage(strike, ball)
            if(!askForRestart(strike, ball)) break
        }
    }

    private fun isValidInput(inputList: MutableList<Int>) {}

    private fun calCount(
        inputList: MutableList<Int>,
        numberList: MutableList<Int>
    ) : Pair<Int, Int> {
        var strike = 0
        var ball = 0
        for(i: Int in 0..< LENGTH) {
            for(j: Int in 0..< LENGTH) {
                if(inputList[i] == numberList[j]) {
                    if(i != j) ball += 1 else strike += 1
                }
            }
        }
        return Pair(strike, ball)
    }

    private fun askForRestart(strike: Int, ball: Int): Boolean{
        if(strike == 3 && ball == 0) {
            baseBallGameMessage.printRestartAndExitMessage()
            person.inputNumber()
            if(isRestart(person.getInputList())) {
                computer.makeComputerNumber()
                return true
            }
            else {
                return false
            }
        }
        return true
    }

    fun isRestart(inputList: MutableList<Int>): Boolean {
        return inputList.size == 1 && inputList[0] == 1
    }
}