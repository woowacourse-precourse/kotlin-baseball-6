package baseball

import baseball.domain.Computer
import baseball.domain.GameLogic
import baseball.domain.User

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val game = GameLogic(Computer.computerNum, User.userNum)
    game.checkResult(Computer.computerNum, User.userNum)
}
