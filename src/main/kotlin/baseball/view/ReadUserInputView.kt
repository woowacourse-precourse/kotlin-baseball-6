package baseball.view

abstract class ReadUserInputView {


    abstract fun readUserInput(): Int

    abstract fun validateNumberFormat(userInput: String)

    abstract fun isCorrectRangeNumber(userNumber: Int): Boolean

    protected fun isNumberFormat(userChoice: String): Boolean {
        return userChoice.all { char -> char.isDigit() }
    }


}