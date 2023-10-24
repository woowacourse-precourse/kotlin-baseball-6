package baseball.utils

/**
 * 해당 문자열이 Int 문자열인지 판별
 * @param includeSign 기호 포함 여부, false 선언 시 숫자 문자열이지만 기호(+, -)가 포함되어 있다면, false를 반환함
 * */
fun String.isInt(includeSign: Boolean = true): Boolean {
    // 부호가 포함되지 않도록 설정했는데, 문자열에 부호를 포함하는 경우
    if (!includeSign && containsSign()) {
        return false
    }

    return this.toIntOrNull() != null
}

/**
 * 해당 문자열의 가장 앞에 기호(+, -)가 포함되어 있는지 판단
 * */
fun String.containsSign(): Boolean =
    this.getOrNull(0) in listOf('+', '-')

fun String.containsDuplicatedNumber(): Boolean {
    val set = mutableSetOf<Char>()
    this.forEach { char ->
        if (set.contains(char)) {
            return true
        }
        set.add(char)
    }
    return false
}

fun String.isRangeOf(start: Int, end: Int): Boolean {
    val range = (start..end).toList()
    this.forEach { char ->
        if (char.digitToInt() !in range) {
            return false
        }
    }
    return true
}