package baseball

import baseball.io.inputBaseBallNumber
import baseball.model.Score
import baseball.util.pickBaseBallNumber

class BaseBallGame {

    fun run() {
        val computerBaseBallList = pickBaseBallNumber()
        while (true) {
            val inputBaseBallList = inputBaseBallNumber()

            val ball = countBall(inputBaseBallList, computerBaseBallList)
            val strike = countStrike(inputBaseBallList, computerBaseBallList)

            val score = Score(ball, strike)
            score.printBallAndStrike()

            if (score.isEndGame()) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                return
            }
        }
    }

    private fun isBall(inputBaseBallIdx: Int, inputBaseBallNumber: Int, computerBaseBallList: List<Int>): Boolean {
        val computerBaseBallIndex = computerBaseBallList.indexOf(inputBaseBallNumber)
        return computerBaseBallIndex != -1 && inputBaseBallIdx != computerBaseBallIndex
    }

    private fun isStrike(inputBaseBallIdx: Int, inputBaseBallNumber: Int, computerBaseBallList: List<Int>): Boolean {
        return computerBaseBallList.indexOf(inputBaseBallNumber) == inputBaseBallIdx
    }

    fun countBall(inputBaseBallList: List<Int>, computerBaseBallList: List<Int>): Int {
        var ball = 0

        inputBaseBallList.forEachIndexed { idx, number ->
            if (isBall(idx, number, computerBaseBallList)) ball++
        }

        return ball
    }

    fun countStrike(inputBaseBallList: List<Int>, computerBaseBallList: List<Int>): Int {
        var strike = 0

        inputBaseBallList.forEachIndexed { idx, number ->
            if (isStrike(idx, number, computerBaseBallList)) strike++
        }

        return strike
    }

}