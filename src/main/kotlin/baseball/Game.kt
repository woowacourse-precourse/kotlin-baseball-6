package baseball

import camp.nextstep.edu.missionutils.Console

class Game(
    private val computerNumberGenerator: ComputerNumberGenerator,
    private val userInput: UserInput,
    private val scoreCalculator: BaseballScoreCalculator,
) {

    private val scorePrinter = ScorePrinter()

    fun start() {
        val computerList = computerNumberGenerator.getNumberList()
        do {
            val userList = userInput.getNumberList()
            val result = scoreCalculator.calculate(computerList, userList)
            scorePrinter.print(result)
        } while (!isGameEnd(computerList, userList))
    }

    fun isRestart(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        return when (Console.readLine()) {
            "1" -> true
            "2" -> false
            else -> throw IllegalArgumentException("1 또는 2가 아닙니다")
        }
    }

    private fun isGameEnd(computerList: List<Int>, userList: List<Int>): Boolean = computerList == userList
}
