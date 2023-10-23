package baseball

import baseball.Object
import baseball.service.GameService
import baseball.view.GameMessage

class Controller {

    private val gameService = GameService()
    private val gameMessage = GameMessage()

    //게임 실행
    fun executeGame() {
        setGame()
        startGame()
        gameOver()
        askReplay()
    }

    //게임 시작전 세팅
    private fun setGame() {
        gameService.setGame()
    }

    //게임 시작
    private fun startGame() {
        gameService.startGame()
    }

    //게임 종료
    private fun gameOver() {
        gameMessage.gameOver()
    }


    //replay 요청
    private fun askReplay() {
        gameMessage.requestReplay()

        val replay = gameService.getReplay()

        when (replay) {
            Object.REPLAY -> {
                executeGame()
            }

            Object.NO_REPLAY -> {}
        }

    }
}