package baseball

import baseball.view.WRONG_INPUT


fun checkInput(num: String) {
    if (num.length != 3 || !isNumber(num)) {
        throw IllegalArgumentException(
            WRONG_INPUT
        )
    }
}

fun checkRestart(num: String) {
    if (num != "1" && num != "2") {
        throw IllegalArgumentException(
            WRONG_INPUT
        )
    }
}

fun isNumber(s: String?): Boolean {
    if (s.isNullOrEmpty()) {
        return false
    }
    for (c in s) {
        if (c <= '0' || c > '9') {
            return false
        }
    }
    return true
}
