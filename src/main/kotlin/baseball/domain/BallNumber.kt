package baseball.domain

data class BallNumber(val ballNumber: Int) {

    companion object {
        private const val MIN_BALL_NUMBER = 1
        private const val MAX_BALL_NUMBER = 9
    }

    init {
        validateBallNumber(ballNumber)
    }

    private fun validateBallNumber(ballNumber: Int) {
        if (ballNumber < MIN_BALL_NUMBER || ballNumber > MAX_BALL_NUMBER) {
            throw IllegalArgumentException("BallNumber는 1~9 사이의 숫자만 가능합니다.")
        }
    }
}