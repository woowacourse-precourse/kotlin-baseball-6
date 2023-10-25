package baseball
import camp.nextstep.edu.missionutils.Console

fun main() {
    val game = GameController(GameView(), Model())
    game.playGame()
}
