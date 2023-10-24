package baseball.domain

class GameLogic(private val computerNum: Int, private val userNum: Int) {

    fun checkResult(): Boolean {

        val strikes = countStrikes(computerNum, userNum)
        val balls = countBalls(computerNum, userNum)

        return when (strikes) {

            3 -> {
                threeStrike()
                true
            }

            else -> {
                checkZeroCount(strikes, balls)
                false
            }
        }
    }

    fun countStrikes(computer: Int, user: Int): Int {
        var strikes = 0
        for (i in computer.toString().indices) {
            if (computer.toString()[i] == user.toString()[i]) strikes++
        }
        return strikes
    }

    fun countBalls(computer: Int, user: Int): Int {
        var balls = 0
        for (digit in user.toString()) {
            if (digit in computer.toString()) balls++
        }
        return balls - countStrikes(computer, user)
    }

    fun threeStrike() {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun checkZeroCount(strikes: Int, balls: Int) {
        when (balls) {
            0 -> when (strikes) {
                0 -> println("낫싱")
                else -> println("${strikes}스트라이크")
            }

            else -> when (strikes) {
                0 -> println("${balls}볼")
                else -> println("${balls}볼 ${strikes}스트라이크")
            }
        }
    }
}