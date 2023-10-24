class System {
    private var computer : Computer = Computer()
    private var user : User = User()
    private var winFlag : Boolean = false

    private fun restartGame() {
        computer.makeNewAnswer()
        winFlag = false
    }

    private fun askRestart() {
        println(STR_ASK_RESTART_MESSAGE)
        user.inputRestartNumber()
        if (user.checkRestart()) {
            restartGame()
        }
    }

    fun game() {
        println(STR_WELCOME_MESSAGE)

        computer.makeNewAnswer()
        while (!winFlag) {
            winFlag = computer.checkAnswer(user.inputNumber())
            if (winFlag)
                askRestart()
        }
    }
}