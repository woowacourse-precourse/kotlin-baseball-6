package baseball

import baseballView.Input
import baseballViewModel.Computer

class BaseballController {
    companion object {
        var WANT_PLAYING = true
        var COMPUTER = ""
        var SCORE = Pair(0, 0)
    }

    private fun printlnMent() {
        println(Input.PlayMent.PLAY_START_MENT)
    }

    fun seekAnswer(user: String): Pair<Int, Int> {
        var score = Pair(0, 0)
        for (index in user.indices) {
            if (COMPUTER[index] == user[index]) {
                score = Pair(score.first + 1, score.second)
            } else if (COMPUTER.contains(user[index])) {
                score = Pair(score.first, score.second + 1)
            }
        }
        return score
    }
    fun playing() {
        printlnMent()
        while (WANT_PLAYING) {
            COMPUTER = Computer().createComputer()
            var user: String
            while (true) {
                user = Input().readInputNumber()
                SCORE = seekAnswer(user)
                Input().printlnScore(SCORE)
                if (COMPUTER == user)
                    break
            }
            WANT_PLAYING = Input().resetGame()
        }
    }
}

