package baseball

import camp.nextstep.edu.missionutils.Randoms


class Computer {

    // 컴퓨터가 랜덤으로 숫자를 생성
    fun generateRandomNumbers(): MutableList<Int> {
        val randomNumbers = mutableListOf<Int>()
        while (randomNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber)
            }
        }
        return randomNumbers
    }

    // 사용자가 입력한 값과 컴퓨터가 생성한 값을 비교
    fun checkUserInput(userInput: String, randomNumber: List<Int>): String {
        val (strike, ball) = calculateStrikeAndBall(userInput, randomNumber)

        return when {
            strike == 3 -> "3스트라이크"
            strike == 0 && ball == 0 -> "낫싱"
            strike == 0 -> "${ball}볼"
            ball == 0 -> "${strike}스트라이크"
            else -> "${ball}볼 ${strike}스트라이크"
        }
    }
    // 스트라이크와 볼의 개수를 계산
    private fun calculateStrikeAndBall(userInput: String, randomNumber: List<Int>): Pair<Int, Int> {
        var strike = 0
        var ball = 0
        for (i in 0..2) {
            if (randomNumber[i] == userInput[i].toString().toInt()) {
                strike++
            } else if (randomNumber.contains(userInput[i].toString().toInt())) {
                ball++
            }
        }
        return Pair(strike, ball)
    }
}