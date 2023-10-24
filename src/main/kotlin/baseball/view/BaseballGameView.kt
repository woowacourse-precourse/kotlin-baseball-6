package baseball.view

import baseball.model.Balls
import baseball.model.Score
import camp.nextstep.edu.missionutils.Console

class BaseballGameView {
    private val inputNumGuideMessage = "숫자를 입력해주세요 : "
    private val gameStartMessage = "숫자 야구 게임을 시작합니다."
    private val gameEndMessage = "3개의 숫자를 모두 맞히셨습니다!"
    private val inputExitGuideMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    private val gameExitMessage = "게임 종료"
    private val gameExitValue = 2

    fun inputUserBalls(): Balls {
        println(inputNumGuideMessage)

        val userNum = inputUserIntForWait()
        val numList = userNum.toString().map { it.toString().toInt() }
        return Balls(numList = numList)
    }

    fun inputGameExit(): Boolean {
        println(inputExitGuideMessage)

        val userInput = inputUserIntForWait()
        require(userInput in 1 until 3) { "$userInput 1 또는 2가 아닙니다." }

        return userInput == gameExitValue
    }

    fun printScore(score: Score) {
        println(score)
    }

    fun printStartMessage() {
        println(gameStartMessage)
    }

    fun printEndMessage() {
        println(gameEndMessage)
    }

    fun printExitMessage() {
        println(gameExitMessage)
    }


    private fun inputUserIntForWait(): Int {
        try {
            return Console.readLine()?.toInt() ?: throw IllegalArgumentException("제대로 입력하세요.")
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력하세요.")
        }
    }
}