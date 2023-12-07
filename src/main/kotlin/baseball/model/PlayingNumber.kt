package baseball.model

import camp.nextstep.edu.missionutils.Randoms

data class PlayingNumber(val numbers: List<Int>) {

    init {
        validateSize(numbers)
        validateNoDuplicateDigits(numbers)
        validateInRange(numbers)
    }

    fun countStrike(playingNumber: PlayingNumber): Int = numbers.zip(playingNumber.numbers).count { (a, b) -> a == b }

    fun countBall(playingNumber: PlayingNumber): Int = numbers.filter { it in playingNumber.numbers }.size - countStrike(playingNumber)

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

    companion object {

        private const val DIGIT_COUNT = 3
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 9

        fun from(playingNumber: String): PlayingNumber {
            val numbers: List<Int> = playingNumber.map { Character.getNumericValue(it) }

            return PlayingNumber(numbers)
        }

        fun pitchBall(): PlayingNumber {
            val uniqueNumbers: MutableSet<Int> = linkedSetOf()

            while (uniqueNumbers.size < DIGIT_COUNT) {
                val randomNumber: Int = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
                uniqueNumbers.add(randomNumber)
            }

            return PlayingNumber(uniqueNumbers.toList())
        }

    }

}
