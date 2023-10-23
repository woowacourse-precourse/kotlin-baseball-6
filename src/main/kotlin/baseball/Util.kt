package baseball

import camp.nextstep.edu.missionutils.Randoms

fun wrongInput(): Nothing {
    throw IllegalArgumentException("잘못된 입력")
}

fun generateAnswer(): String {
    val digits = Randoms.pickUniqueNumbersInRange(1, 9, 3)
    return digits.joinToString(separator = "")
}