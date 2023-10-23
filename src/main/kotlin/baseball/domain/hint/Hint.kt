package baseball.domain.hint

class Hint(private val strikes: Int, private val balls: Int) {
    override fun toString(): String {
        return when {
            this.strikes == 0 && this.balls == 0 -> "낫싱"
            this.strikes != 0 && this.balls == 0 -> "${this.strikes}스트라이크"
            this.strikes == 0 && this.balls != 0 -> "${this.balls}볼"
            else -> "${this.balls}볼 ${this.strikes}스트라이크"
        }
    }
}
