package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer : Player<Unit> {
    private lateinit var numbers: List<Int>

    /**
     * 숫자 리스트의 유효성을 판단하고 올바르면 numbers 프로퍼티에 할당
     */
    override fun generateNumbers(input: String) {
        val generatedUniqueNumbers = generateUniqueNumbers()
        Validator.validateNumbers(generatedUniqueNumbers)
        numbers = generatedUniqueNumbers
    }

    /**
     * START_NUMBER ~ END_NUMBER 범위 내 NUMBER_COUNT 개수만큼 서로 다른 숫자 리스트 생성 후 반환
     */
    private fun generateUniqueNumbers(): List<Int> {
        return generateSequence { Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) }
            .distinct()
            .take(NUMBER_COUNT)
            .toList()
    }

    // FIXME 로직 분리
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