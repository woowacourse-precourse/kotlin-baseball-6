package baseball

class InputCheck {
    fun restartNumberCheck(flag: Int?) {
        requireNotNull(flag) {"입력값이 존재하지 않습니다."}
        require(flag in setOf(1, 2)) {"입력값이 올바르지 않습니다."}
    }

    fun userNumberCheck(input: String?) {
        requireNotNull(input) {"입력값이 존재하지 않습니다."}
        require(input.length == 3) {"입력값이 3자리가 아닙니다."}
        require(input.all { it.isDigit() } && '0' !in input) {"입력값에 0이나 숫자가 아닌 값이 있습니다."}
        require(input.toSet().size == input.length) {"입력값에 중복되는 숫자가 있습니다."}
    }
}