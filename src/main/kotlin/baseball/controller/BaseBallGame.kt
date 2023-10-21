package baseball.controller

import baseball.model.StrikeNumber
import baseball.model.UserNumber
import baseball.view.Guide
import baseball.view.UserInput
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {

    lateinit var strikeNumber: StrikeNumber
    lateinit var userNumber: UserNumber

    fun getStrikeNumber() {
        val tempStrikeNumber = UserInput().getBaseBallNum().map { num -> num.digitToInt() }
        userNumber = UserNumber(tempStrikeNumber)
    }

    fun getUserNumber() {
        val tempUserNumber = UserInput().getBaseBallNum().map { num -> num.digitToInt() }
        userNumber = UserNumber(tempUserNumber)
    }

}