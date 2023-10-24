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

    /**
     * 전달받은 User의 숫자 리스트와 비교해 볼 개수를 반환
     */
    fun calculateBallCount(userNumbers: List<Int>): Int {
        val numbersZip = numbers.zip(userNumbers)
        val userNumbersSet = userNumbers.toSet()

        return numbersZip.count { (computerNumber, userNumber) ->
            computerNumber != userNumber && computerNumber in userNumbersSet
        }
    }

    /**
     * 전달받은 User의 숫자 리스트와 비교해 스트라이크 개수를 반환
     */
    fun calculateStrikeCount(userNumbers: List<Int>): Int {
        val numbersZip = numbers.zip(userNumbers)

        return numbersZip.count { (computerNumber, userNumber) ->
            computerNumber == userNumber
        }
    }

    /**
     * calculateBallAndStrike 메서드의 단위 테스트 목적으로 numbers 프로퍼티에 테스트 숫자 리스트 할당
     */
    fun setNumbersForTesting(testNumbers: List<Int>) {
        numbers = testNumbers
    }
}