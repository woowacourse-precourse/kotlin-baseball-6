package baseball.controller

import baseball.domain.*
import baseball.view.InputView
import baseball.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val answerCreator: AnswerCreator,
) {
    fun run() {
        // 1. 게임 생성
        val answer = answerCreator.create()

        // 2. 게임 실행(정답 맞출 때까지)
        guessRecursive(answer)

        // 3.재실행 여부 입력 및 재실행 or 종료 결정
        if (GameStatus.REPLAY == inputView.inputNextGameStatus()) {
            run()
        }
    }

    private fun guessRecursive(answer: Answer) {
        // 사용자가 추측한 숫자 입력
        val ballNumbers = Guess(inputView.inputBallNumbers())
        // 정답과 비교 후 결과 반환
        val result = answer.compareTo(ballNumbers)

        // 결과 출력
        outputView.printResult(result)

        // 3스트라이크가 아닌 경우 재귀 호출
        if (result.strikeCount != BallNumbers.BALL_COUNT) {
            guessRecursive(answer)
        }
    }

}