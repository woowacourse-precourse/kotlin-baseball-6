package baseball

class BaseBallGame {
    private val computer = Computer()
    private val person = Person()
    private val baseBallGameCounter = BaseBallGameCounter()
    private val baseBallGameMessage = BaseBallGameMessage()
    private val inputValidator = InputValidator()

    //게임 실행 함수
    fun gamePlay() {
        computer.makeComputerNumber()
        baseBallGameMessage.printStartMessage()
        while(true) {
            baseBallGameMessage.printPersonInputMessage()
            person.inputNumber()
            inputValidator.isValidInput(person.getInputList())
            val(strike, ball) = baseBallGameCounter.calCount(person.getInputList(), computer.getNumberList())
            baseBallGameMessage.printCountMessage(strike, ball)
            if(!askForRestart(strike, ball)) break
        }
    }

    //게임 재시작 여부 확인 함수
    private fun askForRestart(strike: Int, ball: Int): Boolean{
        if(strike == 3 && ball == 0) {
            baseBallGameMessage.printGameEndMessage()
            baseBallGameMessage.printRestartAndExitMessage()
            person.inputNumber()
            if(inputValidator.isRestart(person.getInputList())) {
                computer.makeComputerNumber()
                return true
            }
            else {
                return false
            }
        }
        return true
    }
}