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
    fun start(){
        var processNum = CONTINUE_NUM
        guide.start()
        while (processNum == CONTINUE_NUM){
            getStrikeNumber()
            getUserNumber()
        }

    }

    fun getStrikeNumber() {
        val tempStrikeNumber = UserInput().getBaseBallNum().map { num -> num.digitToInt() }
        strikeNumber = StrikeNumber(tempStrikeNumber)
    }

    fun getUserNumber() {
        val tempUserNumber = UserInput().getBaseBallNum().map { num -> num.digitToInt() }
        userNumber = UserNumber(tempUserNumber)
    }

    fun countStrike():Int{
        var strikeCnt = 0
        strikeNumber.numbers.forEachIndexed { idx,num ->
            if(userNumber.numbers[idx] == num) strikeCnt++
        }
        return strikeCnt
    }


    fun countBall():Int{
        var ballCnt = 0
        strikeNumber.numbers.forEachIndexed { idx,num ->
            if(userNumber.numbers[idx] != num && userNumber.numbers.contains(num) ) ballCnt++
        }
        return ballCnt
    }

    companion object{
        const val CONTINUE_NUM = 1
        const val EXIT_NUM = 2
    }

}