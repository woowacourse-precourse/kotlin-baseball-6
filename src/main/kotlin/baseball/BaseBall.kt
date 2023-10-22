package baseball


class BaseBall(val userNum: List<Int>, val gameNum: MutableList<Int>) {  //입력한 값을 파라미터로 받는다
    private var strike = 0
    private var ball = 0

    fun startBaseBall() {
        checkStrike()
        checkBall()
        printBallNum()
    }

    fun isMatchNumber(): String {
        return when (userNum == gameNum) {
            true -> COMPLETE
            else -> CONTINUE
        }
    }

    private fun checkStrike() {
        for (i in userNum.indices) {
            if (userNum[i] == gameNum[i]) {
                strike++
                ball--
            }
        }
    }

    private fun checkBall() {
        for (i in userNum.indices) {
            for (game in gameNum.indices) {
                if (userNum[i] == gameNum[game]) {
                    ball++
                }
            }
        }
    }


    private fun printBallNum() {
        when {
            strike == 3 || (ball == 0 && strike > 0) -> println("${strike}스트라이크")
            strike > 0 && ball > 0 -> println("${ball}볼 ${strike}스트라이크")
            (strike == 0 && ball > 0) -> println("${ball}볼")
            else -> println("낫싱")
        }
    }

    companion object {
        const val COMPLETE = "COMPLETE"
        const val CONTINUE = "CONTINUE"
    }
}

