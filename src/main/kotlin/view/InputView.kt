package view

import camp.nextstep.edu.missionutils.Console
import validator.baseballnumbervalidator.BaseballNumberValidator

object InputView {

    fun askBaseballNumber(baseballNumberValidator: BaseballNumberValidator): String {
        val baseballNumber = Console.readLine()
        baseballNumberValidator.isValidate(baseballNumber)
        return baseballNumber
    }
}