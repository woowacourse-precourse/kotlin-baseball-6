package baseball

class GameStarter(private val controller: GameController, private val view: GameView, private val model: Model) {
    fun startGame() {
        model.modelInit()


    }

    fun chooseGame() {

    }
}