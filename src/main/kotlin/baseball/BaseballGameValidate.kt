package baseball

class BaseballGameValidate {
    fun validateInputUserNumber(userNumber: String) {
        require(userNumber.length == 3) { "3자리가 아닌 입력값입니다." }
        require(userNumber.all { it.isDigit() } && !userNumber.contains("0")) { "숫자가 아닌 입력값이 포함되었습니다." }
        for (x in userNumber) {
            require(userNumber.count { it == x } <= 1) { "중복된 숫자가 있습니다." }
        }
    }

    fun validateRestartAndExit(flag: Int) {
        require(flag in setOf(1, 2)) { "1이나 2가 아닌 다른 입력 값입니다." }
    }
}