class System {
    var computer : Computer = Computer()
    var user : User = User()
    var winFlag : Boolean = false

    fun restartGame() {
        computer.makeNewAnswer()
        winFlag = false
    }

    fun askRestart() {
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