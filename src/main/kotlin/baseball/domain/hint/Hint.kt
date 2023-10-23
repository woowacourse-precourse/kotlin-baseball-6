package baseball.domain.hint

import baseball.domain.game.Turn

class Hint(private val strikes: Int, private val balls: Int) {
    override fun toString(): String {
        return when {
            this.strikes == 3 -> {
                Turn(false)
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
            }
            this.strikes == 0 && this.balls == 0 -> "낫싱"
            this.strikes != 0 && this.balls == 0 -> "${this.strikes}스트라이크"
            this.strikes == 0 && this.balls != 0 -> "${this.balls}볼"
            else -> "${this.balls}볼 ${this.strikes}스트라이크"
        }
    }
}
