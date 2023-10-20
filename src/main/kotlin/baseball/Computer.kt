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
            val userInput = getUserInput()
            val ballCounts = checkUserInput(userInput)
            println(ballCounts)
            if (ballCounts.isStrikeOut()) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                break
            }
        }
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

    private fun checkBallCount(userBall: Int): Int {
        var ballCount = 0
        baseballNumberList.forEach { _computerBall ->
            if (userBall == _computerBall) ballCount++
        }
        return ballCount
    }

    private fun getUserInput(): List<Int> =
        Console.readLine()!!.map {
            it.toString().toInt()
        }
}