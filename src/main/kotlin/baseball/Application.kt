package baseball

import baseball.game.Game

private val game: Game by lazy { Game() }

fun main() {
    game.init()
}
