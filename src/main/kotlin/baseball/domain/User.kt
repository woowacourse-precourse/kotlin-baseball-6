package baseball.domain

import baseball.utils.Number.MAX_NUMBER
import baseball.utils.Number.NINE_CHAR
import baseball.utils.Number.ONE_CHAR
import baseball.utils.UserChoice.EXIT_VALUE
import baseball.utils.UserChoice.RESTART_VALUE

fun String.userNumberValidation() {
    require(length == MAX_NUMBER)

    require(all { number -> number in ONE_CHAR..NINE_CHAR})

    require(toSet().size == MAX_NUMBER)
}

fun String.userChoiceValidation() {
    let { userChoice ->
        require(userChoice == RESTART_VALUE || userChoice == EXIT_VALUE)
    }
}