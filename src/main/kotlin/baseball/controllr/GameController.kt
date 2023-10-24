package baseball.controllr

import baseball.model.GameRulesManager
import baseball.view.GameView
import camp.nextstep.edu.missionutils.Console
/*
김영현
GameController는 게임의 진행을 관리하며, 사용자 입력과 모델 간의 상호작용을 중계합니다.
게임 시작 메시지를 출력하고, 게임 라운드를 반복하여 진행하며, 3스트라이크를 달성하면 게임 재시작 여부를 물어봅니다.
게임이 종료되면 종료 메시지를 출력합니다.
 */
class GameController(private val model: GameRulesManager, private val view: GameView) {

    //게임 진행관리
    fun startGame() {
        view.showStartMessage()

        var isGameEnd = false

        while (!isGameEnd) {
            model.generateComputerNumbers()

            var isRoundEnd = false

            while (!isRoundEnd) {
                val userInput = view.getUserInput()
                val result = model.checkUserGuess(userInput)
                view.showResult(result)

                if (result.contains("게임 종료")) {
                    val restart = Console.readLine()
                    isRoundEnd = true
                    isGameEnd = restart != "1"
                }
            }
        }
        view.showEndGameMessage()
    }

}