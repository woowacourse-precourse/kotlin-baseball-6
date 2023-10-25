package baseball.controller

import baseball.model.TargetNumbersModel
import baseball.view.JudgmentView

class BaseballController(private val numbers: MutableList<Int>) {
    private val baseballModel = TargetNumbersModel(numbers)
    private val judgmentView = JudgmentView()

    fun judgment(userNumbers: MutableList<Int>): String {
        val judgment = getBallResult(userNumbers) + getStrikeResult(userNumbers)
        val result = if (judgment == BLANK) NOTHING else judgment
        judgmentView.result(result)
        return result
    }


    private fun getStrikeResult(userNumbers: MutableList<Int>): String {
        var strikeCnt = 0
        baseballModel.getNumbers().forEachIndexed { idx, num ->
            if (userNumbers[idx] == num) strikeCnt++
        }
        return if (strikeCnt == 0) BLANK else "$strikeCnt$STRIKE"
    }

    private fun getBallResult(userNumbers: MutableList<Int>): String {
        var ballCnt = 0
        baseballModel.getNumbers().forEachIndexed { idx, num ->
            if (userNumbers[idx] != num && userNumbers.contains(num)) ballCnt++
        }
        return if (ballCnt == 0) BLANK else "$ballCnt$BALL$SPACING"
    }

    companion object {
        const val STRIKE = "스트라이크"
        const val BALL = "볼"
        const val NOTHING = "낫싱"
        const val BLANK = ""
        const val SPACING = " "
    }

}