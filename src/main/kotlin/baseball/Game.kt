package baseball

class Game {
    private val user = User()
    private val computer = Computer()

    fun printGameStartMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun gameStart() {
        val computerNumber = computer.setComputerNumber()
        println(computerNumber)

        while (computer.gameFlag) {
            val userNumber = user.inputUserNumber()
            computer.compareAndPrintHint(computerNumber, userNumber)

            if (!computer.gameFlag) {
                printGameEndMessage()
                val restartGame = user.decideGame()
                if (restartGame) {
                    computer.gameFlag = true
                    gameStart()
                }
            }
        }
    }

    private fun printGameEndMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}