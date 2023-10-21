package baseball

import baseball.Constant.Companion.RESTART

class BaseBallGame {
    init {
        println("숫자 야구 게임을 시작합니다.")
        startGame()
    }

    private fun startGame() {
        val computerNumbers = Computer().createComputerBallNumbers()
        runGameLoopUntilCorrectAnswer(computerNumbers)
        checkHasGameEnded()
    }

    private fun runGameLoopUntilCorrectAnswer(targetNumbers: List<Int>) {
        var isAnswerCorrect = false
        var playerNumbers: List<Int>

        while (!isAnswerCorrect) {
            print("숫자를 입력해주세요 : ")
            playerNumbers = Player().createPlayerBallNumbers()
            isAnswerCorrect = targetNumbers == playerNumbers
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun checkHasGameEnded() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput = Player().getRestartOrEndDecisionResult()
        if (userInput == RESTART) startGame()
    }

}