package baseball.domain

import baseball.utils.Number.MAX_NUMBER
import baseball.utils.Number.NINE
import baseball.utils.Number.ONE
import baseball.utils.UserChoice.EXIT_VALUE
import baseball.utils.UserChoice.RESTART_VALUE

object User {

    fun String.userNumberValidation() {
        require(length == MAX_NUMBER)

        map {
            require(it.toString().toInt() in ONE..NINE)
        }

        require(toSet().size == MAX_NUMBER)
    }

    fun String.userChoiceValidation() {
        map {
            require(it.toString() == RESTART_VALUE || it.toString() == EXIT_VALUE)
        }
    }
}