package baseball

import baseball.constants.EXIT
import baseball.io.inputExitGame

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val baseBallGame = BaseBallGame()

    do {
        baseBallGame.run()
    } while (inputExitGame() != EXIT)
}
