package baseball

import baseball.constants.BASEBALL_SIZE
import baseball.io.inputBaseBallNumber
import baseball.io.printBallAndStrike
import baseball.model.Score
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {

    fun run() {
        val computerBaseBallList = pickBaseBallNumber()
        while (true) {
            val inputBaseBallList = inputBaseBallNumber()
            val ball = countBall(inputBaseBallList, computerBaseBallList)
            val strike = countStrike(inputBaseBallList, computerBaseBallList)

            val score = Score(ball, strike)

            printBallAndStrike(score.ball, score.strike)
            if (isEndGame(score.strike)) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            }
        }
    }

    fun pickBaseBallNumber(): List<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < BASEBALL_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }

        return computerNumber
    }

    private fun isBall(inputBaseBallIdx: Int, inputBaseBallNumber: Int, computerBaseBallList: List<Int>): Boolean {
        return computerBaseBallList.indexOf(inputBaseBallNumber) != inputBaseBallIdx
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

    fun isEndGame(strike: Int) = strike == BASEBALL_SIZE

}