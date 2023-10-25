package baseball

import camp.nextstep.edu.missionutils.Console

class Game constructor(
    private val gamePrint: GamePrint = GamePrint()
) {

    fun startGame() {
        while (true) {
            gamePrint.startGamePrint()
            inGame()
            gamePrint.gameOptionPrint()
          
        }
    }

    private fun inGame() {
        val randomNumber = Computer().randomNumbers
        while (true) {

            gamePrint.inputUserPrint()
            val userNumber = Console.readLine().map {
                it.digitToInt()
            }.toList()

        }

    }

}