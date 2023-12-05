package baseball.model

import camp.nextstep.edu.missionutils.Randoms

data class PlayingNumber(val numbers: List<Int>) {

    init {
        validateSize(numbers)
        validateNoDuplicateDigits(numbers)
        validateInRange(numbers)
    }

    companion object {

        private const val DIGIT_COUNT = 3
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 9

        fun of(playingNumber: String): PlayingNumber {
            val numbers = playingNumber.map { Character.getNumericValue(it) }

            return PlayingNumber(numbers)
        }

        fun pitchBall(): PlayingNumber {
            val uniqueNumbers = linkedSetOf<Int>()

            while (uniqueNumbers.size < DIGIT_COUNT) {
                val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
                uniqueNumbers.add(randomNumber)
            }

            return PlayingNumber(uniqueNumbers.toList())
        }

    }

    fun countStrike(pitchNumber: PlayingNumber): Int =
            numbers.zip(pitchNumber.numbers)
                    .count { (a, b) -> a == b }

    fun countBall(pitchNumber: PlayingNumber): Int =
            numbers.filter { it in pitchNumber.numbers }.size - countStrike(pitchNumber)

    private fun validateSize(numbers: List<Int>) {
        require(numbers.size == DIGIT_COUNT) {
            "${DIGIT_COUNT}자리 숫자만 입력해주세요."
        }
    }

    private fun validateNoDuplicateDigits(numbers: List<Int>) {
        val uniqueDigits = numbers.toSet()

        require(uniqueDigits.size == DIGIT_COUNT) {
            "서로 다른 숫자들만 입력해주세요."
        }
    }

    private fun validateInRange(numbers: List<Int>) {
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) {
            "${MIN_NUMBER}~${MAX_NUMBER} 사이의 자연수만 입력해주세요."
        }
    }

}
