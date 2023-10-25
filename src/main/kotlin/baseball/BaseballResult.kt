package baseball

sealed class BaseballResult {
    object Nothing : BaseballResult() {
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

    data class Success(val strike: Strike) : BaseballResult() {
        override fun toString(): String {
            return strike.toString()
        }
    }
}
