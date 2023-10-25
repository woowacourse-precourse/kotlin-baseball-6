package baseball.controller

import baseball.checkInput
import baseball.checkRestart
import baseball.model.createNum
import baseball.view.correctAns
import baseball.view.inputNum
import baseball.view.restart
import baseball.view.showResult
import baseball.view.startGame

class GameController {

    lateinit var ans: String
    var strike = 0
    var ball = 0
    var nothing = 0
    var re = false

    fun play() {

        startGame()
        ans = createNum()

        while (!re) {
            var input = inputNum()

            resetCount()
            checkInput(input)
            checkCount(input)
            showResult(nothing, ball, strike)
            restartGame()
        }
    }

    private fun checkCount(input: String) {
        
        for (i in 0 until 3) {
            if (!ans.contains(input[i])) nothing++

            if (ans.contains(input[i]) && ans[i] != input[i]) ball++

            if (ans.contains(input[i]) && ans[i] == input[i]) strike++
        }
    }

    private fun restartGame() {
        if (strike == 3) {
            correctAns()
            val num = restart()
            checkRestart(num)
            choiceRe(num)
        }
    }

    private fun resetCount() {
        strike = 0
        ball = 0
        nothing = 0
    }

    private fun choiceRe(num : String){
        if (num == "1") ans = createNum()
        if (num == "2") re = true
    }
}