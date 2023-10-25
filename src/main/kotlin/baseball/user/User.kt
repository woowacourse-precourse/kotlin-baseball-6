package baseball.user

class User {
    var randomNumber: String = "000"
    var restartNumber: String = ""

    fun inputRandomNumber(): String {
        this.randomNumber = readLine()!!
        return this.randomNumber
    }

    fun inputRestartNumber(): String {
        this.restartNumber = readLine()!!
        return this.restartNumber
    }
}