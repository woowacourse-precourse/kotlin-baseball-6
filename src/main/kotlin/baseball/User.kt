class User {
    private var userNumber : MutableList<Int> = mutableListOf()
    private var restartCode : String = "1"

    fun checkInputNumber(inputString: String) {
        if (inputString.length != 3) {
            throw IllegalArgumentException("")
        } else if ((inputString[0] == inputString[1]) || (inputString[1] == inputString[2]) || (inputString[0] == inputString[2])) {
            throw IllegalArgumentException("")
        }
    }

    fun inputNumber() : MutableList<Int> {
        print(STR_INPUT_MESSAGE)
        val userInput : String = readLine()!!
        checkInputNumber(userInput)

        userNumber = Utils.stringToIntList(userInput)

        return userNumber
    }

    fun inputRestartNumber() {
        val userInput : String = readLine()!!

        restartCode = userInput
    }

    fun checkRestart() : Boolean {
        if (restartCode == "1")
            return true
        else if (restartCode == "2")
            return false
        else
            throw IllegalArgumentException("")
    }
}