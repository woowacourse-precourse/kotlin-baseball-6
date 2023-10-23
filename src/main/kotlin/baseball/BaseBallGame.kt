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
        var isAnswerCorrect = false
        var playerNumbers: List<Int>

        while (!isAnswerCorrect) {
            print("숫자를 입력해주세요 : ")
            playerNumbers = Player().createPlayerBallNumbers()
            isAnswerCorrect = targetNumbers == playerNumbers

            printMatchedBallInfo(targetNumbers, playerNumbers)
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun printMatchedBallInfo(targetNumbers: List<Int>, playerNumbers: List<Int>) {
        val strikeCount = getStrikeCount(targetNumbers, playerNumbers)
        val ballCount = getBallCount(targetNumbers, playerNumbers)
        when {
            strikeCount == 0 && ballCount == 0 -> println("낫싱")
            ballCount == 0 -> println("${strikeCount}스트라이크")
            strikeCount == 0 -> println("${ballCount}볼")
            else -> println("${ballCount}볼 ${strikeCount}스트라이크")
        }
    }

    private fun getStrikeCount(targetNumbers: List<Int>, playerNumbers: List<Int>): Int {
        return playerNumbers.count { it in targetNumbers && playerNumbers.indexOf(it) == targetNumbers.indexOf(it) }
    }

    private fun getBallCount(targetNumbers: List<Int>, playerNumbers: List<Int>): Int {
        return playerNumbers.count { it in targetNumbers && playerNumbers.indexOf(it) != targetNumbers.indexOf(it) }
    }

    private fun checkHasGameEnded() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        when (Player().getGameEndDecision()) {
            RESTART -> startGame()
            END -> return
        }
    }

}