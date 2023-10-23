package baseball

object Hint {
    fun compareNumber(computer: List<Int>, player: List<Int>) {
        isStrike(computer, player)
        isBall(computer, player)
    }

    private fun isStrike(computer: List<Int>, player: List<Int>) {
        for (i in 0 until 3) {
            if (computer[i] == player[i]) {
                GameCount.plusStrikeCount()
            }
        }
    }

    private fun isBall(computer: List<Int>, player: List<Int>) {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (i != j && computer[i] == player[j]) {
                    GameCount.plusBallCount()
                }
            }
        }
    }

    fun printHint(count: Pair<Int, Int>) {
        val (ball, strike) = count
        when {
            // 볼만 있는경우, 스트라이크만 있는 경우, 볼, 스트라이크 다 있는경우, 낫싱
            ball > 0 && strike == 0 -> println("${ball}볼")
            ball == 0 && strike > 0 -> println("${strike}스트라이크")
            ball > 0 && strike > 0 -> println("${ball}볼 ${strike}스트라이크")
            ball == 0 && strike == 0 -> println("낫싱")
        }
    }
}

