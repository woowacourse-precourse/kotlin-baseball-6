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
        }
    }

    private fun isValidInput(inputList: MutableList<Int>) {}

    private fun calCount(
        inputList: MutableList<Int>,
        numberList: MutableList<Int>
    ) : Pair<Int, Int> {
        var strike = 0
        var ball = 0
        for(i: Int in 0..<LENGTH - 1) {
            for(j: Int in 0..<LENGTH - 1) {
                if(inputList[i] == numberList[j]) {
                    if(i != j) ball += 1 else strike += 1
                }
            }
        }
        return Pair(strike, ball)
    }
}