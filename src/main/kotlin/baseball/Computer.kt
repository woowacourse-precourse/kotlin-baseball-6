package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object Computer {
    private const val REMATCH = 1
    private const val FINISH = 2
    private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "잘못된 값을 입력했습니다."

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
                if (!contains(randomNumber)) {
                    add(randomNumber)
                }
            }
        }
    }

    private fun playGame() {
        println("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 : ")
        while (true) {
            if (checkGameEnd(getUserInput())) {
                break
            }
        }
    }

    private fun checkGameEnd(userInput: List<Int>): Boolean {
        if (userInput.size == 3) {
            val ballCounts = BallCountChecker.checkUserInput(userInput, baseballNumberList)
            println(ballCounts)
            executeIsStrikeOut(ballCounts.isStrikeOut())?.let {_executeIsStrikeOut ->
                return _executeIsStrikeOut
            }
        } else {
            throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE)
        }

        return false
    }

    private fun executeIsStrikeOut(isStrikeOut: Boolean): Boolean? {
        if (isStrikeOut) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            if (checkRematch(Console.readLine()!!.toInt())) {
                startGame()
                return true
            }
            println("게임 종료")
            return true
        }
        return null
    }

    private fun getUserInput(): List<Int> {
        val userInput = Console.readLine()!!.map {
            try {
                it.toString().toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE)
            }
        }

        if (userInput.toSet().size < 3) {
            throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE)
        }

        return userInput
    }

    private fun checkRematch(userInput: Any?): Boolean =
        when (userInput) {
            REMATCH -> true
            FINISH -> false
            else -> throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE)
        }
}