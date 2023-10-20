package baseball

import baseball.Constants.INPUT
import camp.nextstep.edu.missionutils.Console

object Player {
    fun startGame() {
        val answer = Computer.getAnswer()
        while (true) {
            print(INPUT)
            val target = pickNumber()
            val result = ResultManager(target, answer)
            val isSuccessful = result.checkAnswer()
            if (isSuccessful) break
        }
    }

    private fun pickNumber(): MutableList<Int> {
        val input = Console.readLine()
        return InputManager.getNumberList(input)
    }
}