package baseball.model

import baseball.model.BaseballNumbers.Companion.NUMBERS_DIGIT

data class BallAndStrike(
    val strikeCount: Int,
    val ballCount: Int
) {

    fun isSuccess() = strikeCount == NUMBERS_DIGIT

    override fun toString(): String {
        return when {
            (strikeCount > 0 && ballCount > 0) ->
                "$ballCount$BALL_SUFFIX $strikeCount$STRIKE_SUFFIX"

            (strikeCount > 0) -> "$strikeCount$STRIKE_SUFFIX"
            (ballCount > 0) -> "$ballCount$BALL_SUFFIX"
            else -> NOTHING
        }
    }

    companion object {
        const val BALL_SUFFIX = "볼"
        const val STRIKE_SUFFIX = "스트라이크"
        const val NOTHING = "낫싱"
    }
}
