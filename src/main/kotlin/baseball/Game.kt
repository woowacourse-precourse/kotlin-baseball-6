package baseball

class Game {
    private val host = Host()
    private val computer = Computer()

    fun startGame() {
        host.printGameStart()
        computer.createRandomNumber()
        host.printNumberInputRequest()
    }
}