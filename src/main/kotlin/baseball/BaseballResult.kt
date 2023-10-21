package baseball

// TODO sealed class 와 sealed interface 비교
sealed class BaseballResult {
    data object Nothing : BaseballResult() {
        override fun toString(): String {
            return "낫싱"
        }
    }

    data class Ball(val num: Int) : BaseballResult() {
        override fun toString(): String {
            return "${num}볼"
        }
    }

    data class Strike(val num: Int) : BaseballResult() {
        override fun toString(): String {
            return "${num}스트라이크"
        }
    }

    data class BallAndStrike(val ball: Ball, val strike: Strike) : BaseballResult() {
        override fun toString(): String {
            return "$ball $strike"
        }
    }
}
