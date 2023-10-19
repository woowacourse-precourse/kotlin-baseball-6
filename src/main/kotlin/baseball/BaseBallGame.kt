package baseball

import baseball.io.printBallAndStrike
import baseball.util.validateInputBaseBall
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {

    fun run() {
        val computerBaseBallNumber = pickBaseBallNumber()
        while (true) {
            val inputBaseBallNumber = inputBaseBallNumber()
            val ball = countBall(inputBaseBallNumber, computerBaseBallNumber)
            val strike = countStrike(inputBaseBallNumber, computerBaseBallNumber)

            printBallAndStrike(ball, strike)
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

    private fun inputBaseBallNumber(): List<Int> {
        val inputBaseBallNumber = Console.readLine().map { it ->
            it.code - '0'.code
        }

        validateInputBaseBall(inputBaseBallNumber)
        return inputBaseBallNumber
    }

    fun isBall(idx: Int, inputBaseBallNumber: Int, computerBaseBallNumber: List<Int>): Boolean {
        return computerBaseBallNumber.indexOf(inputBaseBallNumber) != idx
    }

    fun isStrike(idx: Int, inputBaseBallNumber: Int, computerBaseBallNumber: List<Int>): Boolean {
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