package baseball
import camp.nextstep.edu.missionutils.Console

fun main() {
    val game = GameStarter(GameController(GameView(), Model()), GameView(), Model())
    game.startGame()
}
