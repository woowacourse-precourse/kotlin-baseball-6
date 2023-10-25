package baseball.model

data class UserNumber(val number: List<Int>) {
    init {
        require(number.toSet().size == 3) { throw IllegalArgumentException(USER_NUMBER_ERROR) }
    }

    companion object {
        private const val USER_NUMBER_ERROR = "서로 다른 3자리수를 입력해주세요"
    }
}
