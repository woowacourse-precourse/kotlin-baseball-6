package baseball.controller

import baseball.model.StrikeNumber
import baseball.model.UserNumber
import baseball.view.Guide
import baseball.view.Result
import baseball.view.UserInput
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {

    private lateinit var strikeNumber: StrikeNumber
    private lateinit var userNumber: UserNumber
    private val guide = Guide()
    private val result = Result()
    private val userInput = UserInput()
    fun start() {
        guide.start()
        var processNum = CONTINUE_NUM
        while (processNum == CONTINUE_NUM) {
            getStrikeNumber()
            var strikeCnt = 0
            var ballCnt: Int
            while (strikeCnt != 3) {
                guide.inputUserNumber()
                getUserNumber()
                strikeCnt = countStrike()
                ballCnt = countBall()
                val curResult = "${getBallResult(ballCnt)}${getStrikeResult(strikeCnt)}"
                if (curResult == "") {
                    println("낫싱")
                } else {
                    result.baseballGame((curResult))
                }
            }
            guide.restart()
            processNum = userInput.getRetryNum().toInt()
        }
        println("게임 종료")

    }
    fun process(){

    }

    fun retry(){

    }

    fun exit(){

    }

    fun getStrikeNumber() {
        val tempStrikeNumber = mutableListOf<Int>()
        while(tempStrikeNumber.size < 3){
            val randomNum = Randoms.pickNumberInRange(1,9)
            if (!tempStrikeNumber.contains(randomNum)) tempStrikeNumber.add(randomNum)
        }
        strikeNumber = StrikeNumber(tempStrikeNumber)
    }

    fun getUserNumber() {
        val tempUserNumber = UserInput().getBaseBallNum().map { num -> num.digitToInt() }
        userNumber = UserNumber(tempUserNumber)
    }

    fun countStrike(): Int {
        var strikeCnt = 0
        strikeNumber.numbers.forEachIndexed { idx, num ->
            if (userNumber.numbers[idx] == num) strikeCnt++
        }
        return strikeCnt
    }

    fun countBall(): Int {
        var ballCnt = 0
        strikeNumber.numbers.forEachIndexed { idx, num ->
            if (userNumber.numbers[idx] != num && userNumber.numbers.contains(num)) ballCnt++
        }
        return ballCnt
    }

    fun getStrikeResult(strikeCnt: Int) = if (strikeCnt == 0) "" else "${strikeCnt}스트라이크"

    fun getBallResult(ballCnt: Int) = if (ballCnt == 0) "" else "${ballCnt}볼 "

    companion object {
        const val CONTINUE_NUM = 1
        const val EXIT_NUM = 2
    }

}