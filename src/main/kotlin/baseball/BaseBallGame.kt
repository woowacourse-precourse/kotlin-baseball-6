package baseball

import baseball.Constant.Companion.END
import baseball.Constant.Companion.RESTART

class BaseBallGame {
    init {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun startGame() {
        val computerNumbers = Computer().createComputerBallNumbers()
        runGameLoopUntilCorrectAnswer(computerNumbers)
        checkHasGameEnded()
    }

    private fun runGameLoopUntilCorrectAnswer(targetNumbers: List<Int>) {
        var isAnswerCorrect: Boolean
        var playerNumbers: List<Int>
        do {
            print("숫자를 입력해주세요 : ")
            playerNumbers = Player().createPlayerBallNumbers()
            isAnswerCorrect = checkAnswer(targetNumbers, playerNumbers)
        } while (!isAnswerCorrect)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun checkAnswer(targetNumbers: List<Int>, playerNumbers: List<Int>): Boolean {
        printMatchedBallInfo(targetNumbers, playerNumbers)
        return targetNumbers == playerNumbers
    }

    private fun printMatchedBallInfo(targetNumbers: List<Int>, playerNumbers: List<Int>) {
        val strikeCount =
            playerNumbers.count { it in targetNumbers && playerNumbers.indexOf(it) == targetNumbers.indexOf(it) }
        val ballCount =
            playerNumbers.count { it in targetNumbers && playerNumbers.indexOf(it) != targetNumbers.indexOf(it) }

        val result = when {
            strikeCount == 0 && ballCount == 0 -> "낫싱"
            ballCount == 0 -> "${strikeCount}스트라이크"
            strikeCount == 0 -> "${ballCount}볼"
            else -> "${ballCount}볼 ${strikeCount}스트라이크"
        }

        println(result)
    }

    private fun checkHasGameEnded() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        when (Player().getGameEndDecision()) {
            RESTART -> startGame()
            END -> return
            else -> return // TODO 예외처리
        }
    }

}