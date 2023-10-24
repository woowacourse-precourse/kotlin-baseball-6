package baseball

import baseball.validcheck.Exceptions

class BaseballGame() {
    private val messages = Messages()

    fun gameStart() {
        while (true) {
            val computer = Computer()
            val user = User()
            messages.printGameStartMessage()
            playBaseballGame(user, computer)
            messages.printReGameMessage()
            if (user.reGame()) break
        }
    }

    private fun playBaseballGame(user: User, computer: Computer) {
        while (true) {
            messages.printInputMessage()
            val readNumber = user.readNumbers()
            Exceptions().inputNumberException(readNumber)
            val result = resultString(
                countingBall(computer.randomBalls, readNumber),
                countingStrike(computer.randomBalls, readNumber)
            )
            println(result)
            if (checkThreeStrike(computer.randomBalls, readNumber)) break
        }
    }

    private fun countingBall(computer: List<Int>, input: String): Int {
        var count = ZERO_COUNT
        for (number in computer) {
            if (input.contains(number.toString())) count++
        }
        return count
    }

    private fun countingStrike(computer: List<Int>, input: String): Int {
        var count = ZERO_COUNT
        for (number in computer.indices) {
            if (input.indexOf(computer[number].toString()) == number) count++
        }
        return count
    }

    private fun resultString(ball: Int, strike: Int): String {
        return when {
            strike == ZERO_COUNT && ball == ZERO_COUNT -> NOTHING
            strike == FULL_COUNT -> THREE_STRIKE
            ball == strike -> "${strike}$STRIKE"
            strike != ZERO_COUNT -> "${ball - strike}$BALL ${strike}$STRIKE"
            else -> "${ball}$BALL"
        }
    }

    private fun checkThreeStrike(computer: List<Int>, input: String): Boolean {
        if (countingStrike(computer, input) == FULL_COUNT) {
            messages.printGameEndMessage()
            return true
        }
        return false
    }

    companion object {
        private const val NOTHING = "낫싱"
        private const val THREE_STRIKE = "3스트라이크"
        private const val STRIKE = "스트라이크"
        private const val BALL = "볼"
        private const val ZERO_COUNT = 0
        private const val FULL_COUNT = 3
    }
}

