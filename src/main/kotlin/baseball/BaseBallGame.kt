package baseball

import baseball.io.inputBaseBallNumber
import baseball.io.printBallAndStrike
import baseball.model.Score
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {

    fun run() {
        val computerBaseBallNumber = pickBaseBallNumber()
        while (true) {
            val inputBaseBallNumber = inputBaseBallNumber()
            val ball = countBall(inputBaseBallNumber, computerBaseBallNumber)
            val strike = countStrike(inputBaseBallNumber, computerBaseBallNumber)

            val score = Score(ball, strike)

            printBallAndStrike(score.ball, score.strike)
            if (strike == 3) {
                print("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
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

    private fun isBall(idx: Int, inputBaseBallNumber: Int, computerBaseBallNumber: List<Int>): Boolean {
        return computerBaseBallNumber.indexOf(inputBaseBallNumber) != idx
    }

    private fun isStrike(idx: Int, inputBaseBallNumber: Int, computerBaseBallNumber: List<Int>): Boolean {
        return computerBaseBallNumber.indexOf(inputBaseBallNumber) == idx
    }

    fun countBall(inputBaseBallNumber: List<Int>, computerBaseBallNumber: List<Int>): Int {
        var ball = 0

        inputBaseBallNumber.forEachIndexed { idx, number ->
            if (isBall(idx, number, computerBaseBallNumber)) ball++
        }

        return ball
    }

    fun countStrike(inputBaseBallNumber: List<Int>, computerBaseBallNumber: List<Int>): Int {
        var strike = 0

        inputBaseBallNumber.forEachIndexed { idx, number ->
            if (isStrike(idx, number, computerBaseBallNumber)) strike++
        }

        return strike
    }

    companion object {
        const val BASEBALL_SIZE = 3
    }

}