package view

import camp.nextstep.edu.missionutils.Console
import validator.baseballnumbervalidator.BaseballNumberValidator
import validator.gamecontrolvalidator.GameControlValidator

object InputView {

    fun askBaseballNumber(baseballNumberValidator: BaseballNumberValidator): String {
        val baseballNumber = Console.readLine()
        baseballNumberValidator.isValidate(baseballNumber)
        return baseballNumber
    }

    fun inputReStartOrExit(gameControlValidator: GameControlValidator): String {
        val zeroOrOne = Console.readLine()
        gameControlValidator.isValidate(zeroOrOne)
        return zeroOrOne
    }
}