package baseball

class Game {
    private val player = Player()
    private val umpire = Umpire()
    private val commentator = Commentator()
    private val computer: Computer = Computer()

    fun start() {
        commentator.commentate(MessageConstants.GAME_START)
        do {
            playGameUntilFinish()
        } while (wantsToRestart())
    }

    private fun playGameUntilFinish() {
        val computerNumbers = computer.getGameNumbers()
        var ballCount: BallCount
        do {
            commentator.commentate(MessageConstants.INPUT_GAME_NUMBERS, false)
            val guessGameNumbers = player.guessGameNumbers()
            ballCount = umpire.judge(guessGameNumbers, computerNumbers)
            commentator.commentate(ballCount)
        } while (isContinuous(ballCount))
        commentator.commentate(MessageConstants.GAME_FINISH)
    }

    private fun isContinuous(ballCount: BallCount) = !ballCount.isThreeStrike()

    private fun wantsToRestart(): Boolean {
        commentator.commentate(MessageConstants.RESTART_OR_EXIT)
        if (player.askReplayOption() == ReplayOption.EXIT) {
            return false
        }
        computer.changeGameNumbers()
        return true
    }
}