package baseball

import baseball.BaseballResult.*

class BaseballGame {

    private val console: BaseballConsole by lazy {
        BaseballConsole()
    }
    private val engine: BaseballEngine by lazy {
        BaseballEngine()
    }

    private lateinit var computer: BaseballNum

    fun start() {
        computer = initialize()
        val userInput = getUserInput()
        produceResult(computer, userInput)
    }

    private fun restart() {
        val userInput = getUserInput()
        produceResult(computer, userInput)
    }

    /** TODO
     * Triple 이 좋을지 List 가 좋을지는 생각해봐야할듯.
     * 우선 Triple 자체는 outOfBound가 발생할 일 이 없으므로 조금 더 안정적임
     * 그리고 구조 분해의 장점이 있음
     * 핵심적인 기능은 아니니까. 컴퓨터 - 사용자 숫자 비교할 때 어느게 속도가 빠를지
     */
    private fun initialize(): BaseballNum {
        console.printWelcomeMessage()
        return engine.generateRandomNumber()
    }

    private fun getUserInput(): BaseballNum {
        val userInput = console.getInput()
        val isValid = verifyUserInput(userInput)
        if (isValid) {
            return userInput?.toBaseballNum() ?: throw IllegalArgumentException()
        } else {
            throw IllegalArgumentException()
        }
    }

    private fun verifyUserInput(userInput: String?): Boolean {
        return if (userInput.isNullOrEmpty()) {
            false
        } else {
            if (userInput.length != 3) {
                false
            } else {
                try {
                    userInput.toInt()
                    true
                } catch (nfe: NumberFormatException) {
                    false
                }
            }
        }
    }

    private fun produceResult(computer: BaseballNum, userInput: BaseballNum) {
        val result = engine.compare(computer, userInput)
        console.printResult(result)

        if (result is Strike && result.num == 3) {
            end()
        } else {
            restart()
        }
    }

    private fun end() {
        console.printEndMessage()
        console.getEndFlag()
    }
}
