package baseball

import camp.nextstep.edu.missionutils.Console

object User {

    fun enterUserNumbers(): String = Console.readLine()

    fun String.userNumberValidation() {
        require(length == 3)

        map {
            require(it in '1'..'9')
        }

        require(toSet().size == 3)
    }

    fun String.userChoiceValidation() {
        map {
            require(it == '1' || it == '2')
        }
    }
}