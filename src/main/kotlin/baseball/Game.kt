package baseball

class Game {
    private val host = Host()
    private val computer = Computer()
    private val player = Player()

    fun startGame() {
        host.printGameStart()
        var computerRandomNumber = computer.createRandomNumber()

        while (true) {
            val playerInputNumber = getPlayerInputNumber()
            val strikeCount = computer.checkNumberAndPrintResult(computerRandomNumber, playerInputNumber)

            if (strikeCount == 3) {
                host.printGameContinueOrNot()
                val gameContinueOrNot = player.inputContinueGameOrNot()
                if (gameContinueOrNot == END) {
                    break
                } else if (gameContinueOrNot == CONTINUE) {
                    computerRandomNumber = computer.createRandomNumber()
                }
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