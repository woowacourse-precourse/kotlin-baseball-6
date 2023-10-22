package baseball.domain

class CompareNumbers {

    fun compareEachNumbers(randomNumbers: MutableList<Int>, userInputtedNumber: Int): Map<BallCount, Int> {
        var strikes = 0
        var balls = 0
        val userNumbers = convertUserNumber(userInputtedNumber)

        userNumbers.forEachIndexed { index, number ->
            if (randomNumbers.contains(number)) {
                if (randomNumbers.indexOf(number) == index) {
                    strikes++
                } else {
                    balls++
                }
            }
        }
        val resultMap = mutableMapOf<BallCount, Int>()
        resultMap[BallCount.Strike] = strikes
        resultMap[BallCount.Ball] = balls
        return resultMap
    }

    private fun convertUserNumber(userNumber: Int): MutableList<Int> {
        var currentNumber = userNumber
        val userNumbers = mutableListOf<Int>()
        val lastNumber = currentNumber % 10
        if (lastNumber == 0) throw IllegalArgumentException("0 입력 오류!")
        userNumbers.add(lastNumber)
        currentNumber /= 10

        val middleNumber = currentNumber % 10
        if (middleNumber == 0) throw IllegalArgumentException("0 입력 오류!")
        userNumbers.add(0, middleNumber)
        currentNumber /= 10

        val firstNumber = currentNumber % 10
        userNumbers.add(0, firstNumber)
        return userNumbers
    }


}