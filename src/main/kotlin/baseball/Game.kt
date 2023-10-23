package baseball

class Game {
    private val host = Host()
    private val computer = Computer()

    fun startGame() {
        host.printGameStart()
        val computerRandomNumber = computer.createRandomNumber()
        while (true) {
            val playerInputNumber = getPlayerInputNumber()
            val strikeCount = computer.checkNumberAndPrintResult(computerRandomNumber, playerInputNumber)
            if (strikeCount == 3) {
                host.printGameContinueOrNot()
                break
            }
        }
    }

    private fun getPlayerInputNumber(): List<Int> {
        host.printNumberInputRequest()
        val playerInputNumber = computer.convertInputNumberToList()
        computer.validateInputNumber(playerInputNumber)
        return playerInputNumber
    }
}