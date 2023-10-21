package baseball.controller

import baseball.model.BaseballModel
import baseball.view.JudgmentView

class BaseballController(private val numbers:MutableList<Int>) {
    private val baseballModel = BaseballModel(numbers)
    private val judgmentView = JudgmentView()

    fun judgment(userNumbers:MutableList<Int>):String{
        val judgment = getStrikeResult(userNumbers)+getBallResult(userNumbers)
        val result = if (judgment == "") "낫씽" else judgment
        judgmentView.result(result)
        return result
    }


    private fun getStrikeResult(userNumbers:MutableList<Int>):String{
        var strikeCnt = 0
        baseballModel.getNumbers().forEachIndexed { idx, num ->
            if (userNumbers[idx] == num) strikeCnt++
        }
        return if (strikeCnt==0) "" else "${strikeCnt}스트라이크"
    }

    fun getBallResult(userNumbers:MutableList<Int>): String {
        var ballCnt = 0
        baseballModel.getNumbers().forEachIndexed { idx, num ->
            if (userNumbers[idx] != num && userNumbers.contains(num)) ballCnt++
        }
        return if (ballCnt==0) "" else "${ballCnt}볼 "
    }

}