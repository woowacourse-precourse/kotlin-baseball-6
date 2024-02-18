package baseball.domain

import baseball.view.OutputView

class Judge {

    fun judgeGameResult(numberSize: Int, computerNumbers: MutableList<Int>, userNumbers: String): Boolean {
        val strikeCount = judgeStrike(numberSize, computerNumbers, userNumbers)
        val ballCount = judgeBall(numberSize, computerNumbers, userNumbers)
        OutputView.printJudgeResult(ballCount, strikeCount)
        return isGameOver(strikeCount, numberSize)
    }

    private fun judgeBall(numberSize: Int, computerNumbers: MutableList<Int>, userNumbers: String): Int {
        var ballCount = 0
        for (i in 0 until numberSize) {
            if (computerNumbers.contains(userNumbers[i].toString().toInt())) {
                if (computerNumbers[i] != userNumbers[i].toString().toInt()) {
                    ballCount++
                }
            }
        }
        return ballCount
    }

    private fun judgeStrike(numberSize: Int, computerNumbers: MutableList<Int>, userNumbers: String): Int {
        var strikeCount = 0
        for (i in 0 until numberSize) {
            if (computerNumbers[i] == userNumbers[i].toString().toInt()) {
                strikeCount++
            }
        }
        return strikeCount
    }

    private fun isGameOver(strikeCount: Int, numberSize: Int): Boolean {
        return strikeCount == numberSize
    }

}