package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballGame() {

    fun gameStart() {
        while (true) {
            val computer = Computer()
            val user = User()
            println("숫자 야구 게임을 시작합니다.")
            playBaseballGame(user, computer)
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            if (user.reGame()) break
        }
    }

    private fun playBaseballGame(user: User, computer: Computer) {
        while (true) {
            println("숫자를 입력해주세요 : ")
            val readNumber = user.readNumbers()
            inputNumberException(readNumber)
            val result = resultString(
                countingBall(computer.randomBalls, readNumber),
                countingStrike(computer.randomBalls, readNumber)
            )
            println(result)
            if (checkThreeStrike(computer.randomBalls, readNumber)) break
        }
    }

    private fun countingBall(computer: MutableList<Int>, input: String): Int {
        var count = 0
        for (number in computer) {
            if (input.contains(number.toString())) count++
        }
        return count
    }

    private fun countingStrike(computer: MutableList<Int>, input: String): Int {
        var count = 0
        for (number in 0 until computer.size) {
            if (input.indexOf(computer[number].toString()) == number) count++
        }
        return count
    }

    private fun resultString(ball: Int, strike: Int): String {
        return when {
            strike == 0 && ball == 0 -> "낫싱"
            strike == 3 -> "3스트라이크"
            ball == strike -> "${strike}스트라이크"
            strike != 0 -> "${ball - strike}볼 ${strike}스트라이크"
            else -> "${ball}볼"
        }
    }

    private fun checkThreeStrike(computer: MutableList<Int>, input: String): Boolean {
        if (countingStrike(computer, input) == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return true
        }
        return false
    }

    private fun inputNumberException(input: String) {
        when {
            input.toSet().size < 3 -> throw IllegalArgumentException("중복된 수입니다.")
            input.length > 3 -> throw IllegalArgumentException("3자리 수만 입력해주세요")
            isNotNumber(input) -> throw IllegalArgumentException("0을 제외한 숫자만 입력해 주세요")
        }
    }

    private fun isNotNumber(input: String) = !("[1-9]{3}".toRegex()
        .matches(input))
}
