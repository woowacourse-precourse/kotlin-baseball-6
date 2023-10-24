package baseball

import camp.nextstep.edu.missionutils.Randoms

fun wrongInput(): Nothing {
    throw IllegalArgumentException("잘못된 입력")
}

fun generateAnswer(): String {
    val digits = mutableSetOf<Int>()
    while (digits.size < 3) {
        val digit = Randoms.pickNumberInRange(1, 9)
        digits.add(digit)
    }
    return digits.joinToString(separator = "")
}