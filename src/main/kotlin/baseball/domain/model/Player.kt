package baseball.domain.model

data class Player(
    val number: List<Int>,
) {
    init {
        require(number.size == 3) { "[ERROR] 3개가 아님" }
        require(number.all { it in 1..9 }) { "[ERROR] 1~9 사이가 아님" }
        require(number.toSet().size == 3) { "[ERROR] 중복 있음" }
    }
}