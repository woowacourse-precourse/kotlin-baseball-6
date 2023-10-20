package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private lateinit var baseballNumberList: MutableList<Int>

    fun startGame() {
        setBaseBallNumberList()
        playGame()
    }

    private fun setBaseBallNumberList() {
        baseballNumberList = mutableListOf()
        with(baseballNumberList) {
            while (size < 3) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!contains(randomNumber)) add(randomNumber)
            }
        }
    }

    private fun playGame() {
        println("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 : ")
        while (true) {
            if (checkGameEnd(getUserInput())) break
        }
    }

    private fun checkGameEnd(userInput: List<Int>): Boolean {
        if (userInput.size == 3) {
            val ballCounts = checkUserInput(userInput)
            println(ballCounts)
            if (ballCounts.isStrikeOut()) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                if (checkRematch(Console.readLine()!!.toInt())) {
                    startGame()
                    return true
                }
                println("게임 종료")
                return true
            }
        } else throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE)

        return false
    }

    private fun checkUserInput(userInput: List<Int>): BallCount {
        var strikeCount = 0
        var ballCount = 0
        userInput.forEachIndexed { _index, _ball ->
            if (_ball == baseballNumberList[_index]) strikeCount++
            else ballCount += checkBallCount(_ball)
        }
        return BallCount(strikeCount, ballCount)
    }

    private fun checkBallCount(userBall: Int): Int = baseballNumberList.count { _computerBall ->
        _computerBall == userBall
    }

    private fun getUserInput(): List<Int> =
        Console.readLine()!!.map {
            it.toString().toInt()
        }

    private fun checkRematch(userInput: Any?): Boolean =
        when (userInput) {
            REMATCH -> true
            FINISH -> false
            else -> throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE)
        }

    companion object {
        private const val REMATCH = 1
        private const val FINISH = 2
        private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "잘못된 값을 입력했습니다."
    }
}