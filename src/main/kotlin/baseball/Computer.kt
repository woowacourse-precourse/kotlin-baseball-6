package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer : Player<Unit> {
    private lateinit var numbers: List<Int>

    /**
     * @param input 사용자로부터의 입력 문자열 (선택적)
     * @throws IllegalArgumentException 유효성 검사 실패 시 발생
     */
    override fun generateNumbers(input: String) {
        val generatedNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT)
        Validator.validateNumbers(generatedNumbers)
        numbers = generatedNumbers
    }

    fun calculateBallAndStrike(userNumbers: List<Int>): BallAndStrikeCounts {
        val numbersZip = numbers.zip(userNumbers)
        val playerNumbersSet = userNumbers.toSet()

        val ballCount = numbersZip.count { (computerNumber, playerNumber) ->
            computerNumber != playerNumber && computerNumber in playerNumbersSet
        }
        val strikeCount = numbersZip.count { (computerNumber, playerNumber) ->
            computerNumber == playerNumber
        }

        return BallAndStrikeCounts(ballCount, strikeCount)
    }

    /**
     * calculateStrikeAndBall 메서드의 단위 테스트 목적으로 numbers 프로퍼티에 특정 숫자를 설정
     * @param testNumbers 테스트용 숫자 리스트
     */
    fun setNumbersForTesting(testNumbers: List<Int>) {
        numbers = testNumbers
    }
}