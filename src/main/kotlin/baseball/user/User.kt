package baseball.user

import camp.nextstep.edu.missionutils.Console

class User {
    var randomNumber: String = "000"
    var restartNumber: String = ""

    fun inputRandomNumber(): String {
        this.randomNumber = Console.readLine()
        return this.randomNumber
    }

    fun inputRestartNumber(): String {
        this.restartNumber = Console.readLine()
        return this.restartNumber
    }
}