package baseball.domain.player

data class PlayerNumbers(private val numbers: List<PlayerNumber>) {

    init {
        require(this.numbers.size == NUMBER_SIZE) { LENGTH_ERROR_MESSAGE }
    }

    fun getBallStatus(index: Int, number: PlayerNumber): BallStatus {
        if (this.numbers[index] == number) return BallStatus.STRIKE
        if (this.numbers.contains(number)) return BallStatus.BALL
        return BallStatus.NOTHING
    }

    companion object {
        private const val LENGTH_ERROR_MESSAGE = "입력값은 3자리여야 합니다."
        private const val NUMBER_SIZE = 3
    }
}
