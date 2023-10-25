package baseball

import baseball.Constant.NUMBER_LENGTH

object Hint {
    fun compareNumber(computer: List<Int>, player: List<Int>) {
        for (index in 0 until NUMBER_LENGTH) {
            // 스트라이크 판별
            if (computer[index] == player[index]) {
                GameCount.plusStrikeCount()
                // 볼 판별
            } else if (player.contains(computer[index])) {
                GameCount.plusBallCount()
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

