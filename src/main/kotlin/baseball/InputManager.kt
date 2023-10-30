package baseball

fun isValidateInputString(input: String) {
    // 빈 문자열 확인
    if (input.isBlank()) throw IllegalArgumentException("input string is empty")
    // 3자리 수 길이 확인
    if (input.length != 3) throw IllegalArgumentException("input string's length is not suitable")
    // 0 포함 확인
    if (input.contains('0')) throw IllegalArgumentException("input string should not contains '0'")
    // 숫자 변환 가능 여부
    if (input.toIntOrNull() == null) throw IllegalArgumentException("input string is not parseable")
    // 중복값 확인
    if (isDuplicated(input)) throw IllegalArgumentException("number is duplicated in input string")
}

fun isDuplicated(input: String): Boolean {
    input.forEachIndexed { index, num ->
        var count = 0
        for (j in index..input.lastIndex) {
            if (num == input[j]) {
                count++
            }
        }
        if (count > 1) return true
    }
    return false
}

fun isValidateFinishNumber(input: String) {
    // 빈 문자열 확인
    if (input.isBlank()) throw IllegalArgumentException("input string is empty")
    // 1 또는 2 외의 값 확인
    if (input != "1" && input != "2") throw IllegalArgumentException("input string is not available value")
}