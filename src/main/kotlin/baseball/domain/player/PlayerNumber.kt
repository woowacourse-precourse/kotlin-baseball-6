package baseball.domain.player

import baseball.domain.Constants

data class PlayerNumber(val numbers: Int) {
    init {
        require(this.numbers in Constants.DIGIT_RANGE) { Constants.INVALID_DIGIT_ERROR_MESSAGE }
    }
}
