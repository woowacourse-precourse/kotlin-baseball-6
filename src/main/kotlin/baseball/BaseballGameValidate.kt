package baseball

class BaseballGameValidate {
    fun validateInputUserNumber(userNumber: String) {
        require(userNumber.length == 3) { "3자리가 아닌 입력값입니다." } // 3자리 미만, 초과 모두 오류 출력
        require(userNumber.all { it.isDigit() } && !userNumber.contains("0")) { "숫자가 아닌 입력값이 포함되었습니다." } // 숫자가 아니거나 0이 포함된 경우
        for (x in userNumber) {
            require(userNumber.count { it == x } <= 1) { "중복된 숫자가 있습니다." } // 같은 수가 1개 이상인 경우
        }
    }

    fun validateRestartAndExit(flag: Int) {
        require(flag in setOf(1, 2)) { "1이나 2가 아닌 다른 입력 값입니다." }
    }
}