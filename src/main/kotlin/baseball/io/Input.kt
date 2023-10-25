package baseball.io

import baseball.exception.ExceptionChecker
import camp.nextstep.edu.missionutils.Console

class Input(
    private val printer: Output = Output(),
    private val exceptionChecker: ExceptionChecker = ExceptionChecker()
) {

    fun inputMyNumber(): String {
        printer.askNumber()

        var myNum: String
        try {
            myNum = Console.readLine()
            exceptionChecker.checkValidation(myNum)
        } catch (e: Exception) {
            throw e
        }
        return myNum
    }

    fun inputRetryChoice(): String {
        printer.printSuccessMessage()
        var choice:String
        try {
            choice = Console.readLine()
            exceptionChecker.checkRetryInput(choice)
        } catch (e: Exception) {
            throw e
        }

        return choice
    }
}