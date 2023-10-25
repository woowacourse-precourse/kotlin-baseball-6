package baseball.domain

import baseball.resources.*

fun String.userNumberValidation() {
    require(all { number -> Character.isDigit(number) }) {
        NOT_DIGIT_ERROR
    }

    require(all { number -> number.digitToInt() != ZERO }) {
        CONTAIN_ZERO_ERROR
    }

    require(length == MAX_NUMBER) {
        NOT_THREE_DIGITS_ERROR
    }

    require(toSet().size == MAX_NUMBER) {
        DUPLICATES_NUMBER_ERROR
    }
}

fun String.userChoiceValidation() {
    let { userChoice ->
        require(userChoice == RESTART_VALUE || userChoice == EXIT_VALUE) {
            NOT_ONE_OR_TWO_ONLY_ERROR
        }
    }
}