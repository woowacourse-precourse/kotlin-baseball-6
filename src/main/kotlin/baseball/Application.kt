package baseball

fun main() {
    val game = BaseballGameViewModel(BaseballGameModel(), BaseballGameView(BaseballGameValidate()))
    game.gameRun()
}
