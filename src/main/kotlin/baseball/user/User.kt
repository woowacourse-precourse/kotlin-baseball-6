package baseball.user

class User {
    var randomNumber: String = "000"
    var restartNumber: Int = -1

    fun inputRandomNumber(): String {
        this.randomNumber = readLine()!!
        return this.randomNumber
    }

    fun inputRestartNumber(): Int {
        this.restartNumber = readLine()!!.toInt()
        return this.restartNumber
    }
}