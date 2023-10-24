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

            checkInput(input)
            checkCount(input)
            showResult(nothing, ball, strike)
            restartGame()
        }
    }
    //정답 카운트 체크
    fun checkCount(input: String) {
        strike = 0
        ball = 0
        nothing = 0

        for (i in 0 until 3) {

            if (!ans.contains(input[i])) {
                nothing++
            }
            if (ans.contains(input[i]) && ans[i] != input[i]) {
                ball++
            }
            if (ans.contains(input[i]) && ans[i] == input[i]) {
                strike++
            }
        }
    }
    //재시작 여부 선택
    fun restartGame() {
        if (strike == 3) {
            correctAns()
            val num = restart()
            checkRestart(num)

            when (num) {
                "1" -> ans = createNum()
                "2" -> re = true
            }
        }
    }
}