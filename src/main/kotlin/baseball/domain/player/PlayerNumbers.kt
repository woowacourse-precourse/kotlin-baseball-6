package baseball.domain.player

import baseball.domain.Constants
import baseball.domain.game.BallStatus

data class PlayerNumbers(private val numbers: List<PlayerNumber>) {

    val size: Int get() = this.numbers.size
    val indices: IntRange get() = this.numbers.indices
    operator fun get(index: Int): PlayerNumber = this.numbers[index]

    init {
        require(this.numbers.size == Constants.NUMBER_SIZE) { Constants.LENGTH_ERROR_MESSAGE }
        require(this.numbers.distinct().size == Constants.NUMBER_SIZE) { Constants.DUPLICATED_ERROR_MESSAGE }
    }

    fun getBallStatus(index: Int, number: PlayerNumber): BallStatus {
        if (this.numbers[index] == number) return BallStatus.STRIKE
        if (this.numbers.contains(number)) return BallStatus.BALL
        return BallStatus.NOTHING
    }
}
