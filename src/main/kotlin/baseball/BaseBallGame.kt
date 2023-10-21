package baseball

class BaseBallGame {
    init {
        println("숫자 야구 게임을 시작합니다.")
        startGame()
    }

    private fun startGame() {
        val computerNumbers = Computer().createComputerBallNumbers()
        runGameLoopUntilCorrectAnswer(computerNumbers)
    }

    private fun runGameLoopUntilCorrectAnswer(targetNumbers: List<Int>) {
        var isAnswerCorrect = false
        var playerNumbers: List<Int>

        while (!isAnswerCorrect) {
            print("숫자를 입력해주세요 : ")
            playerNumbers = Player().createComputerBallNumbers()
            isAnswerCorrect = targetNumbers == playerNumbers
        }
    }

}