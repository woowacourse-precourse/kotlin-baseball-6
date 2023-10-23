package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer : Player<Unit> {
    private lateinit var numbers: List<Int>

    /**
     * @param input 사용자로부터의 입력 문자열 (선택적)
     * @throws IllegalArgumentException 유효성 검사 실패 시 발생
     */
    override fun generateNumbers(input: String) {
        numbers = generateSequence { Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) }
            .distinct()
            .take(NUMBER_COUNT)
            .toList()
        Validator.validateNumbers(numbers)
    }

    fun calculateBallAndStrike(userNumbers: List<Int>): BallAndStrikeCounts {
        val numbersZip = numbers.zip(userNumbers)
        val userNumbersSet = userNumbers.toSet()

        val ballCount = numbersZip.count { (computerNumber, userNumber) ->
            computerNumber != userNumber && computerNumber in userNumbersSet
        }
        val strikeCount = numbersZip.count { (computerNumber, userNumber) ->
            computerNumber == userNumber
        }

        return BallAndStrikeCounts(ballCount, strikeCount)
    }

    /**
     * calculateBallAndStrike 메서드의 단위 테스트 목적으로 numbers 프로퍼티에 테스트 숫자 리스트를 할당
     * @param testNumbers 테스트용 숫자 리스트
     */
    fun setNumbersForTesting(testNumbers: List<Int>) {
        numbers = testNumbers
    }
}