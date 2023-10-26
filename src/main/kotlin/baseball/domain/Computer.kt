package baseball.domain

class Computer(
    private val answerCreator: AnswerCreator,
    private var answer: Answer? = null,
) {
    fun createAnswer() {
        answer = answerCreator.create()
    }

    fun checkGuess(guess: Guess): GameResult {
        if (answer == null) {
            throw IllegalStateException("컴퓨터가 아직 정답을 생성하지 않았습니다.")
        }
        return GameResult(
            answer!!.countStrikes(guess),
            answer!!.countBalls(guess),
        )
    }
}