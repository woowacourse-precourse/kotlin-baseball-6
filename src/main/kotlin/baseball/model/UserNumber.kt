package baseball.model

data class UserNumber(val number: List<Int>) {
    init {
        require(number.toSet().size == 3) { throw IllegalArgumentException(USER_NUMBER_ERROR) }
        require(!number.contains(0)) { throw IllegalArgumentException(USER_NUMBER_ZERO_ERROR) }
    }

    companion object {
        private const val USER_NUMBER_ERROR = "서로 다른 3자리수를 입력해주세요"
        private const val USER_NUMBER_ZERO_ERROR = "1-9의 수만 입력 가능합니다"
    }
}
