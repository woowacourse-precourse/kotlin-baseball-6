package baseball.domain

import baseball.resources.*

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