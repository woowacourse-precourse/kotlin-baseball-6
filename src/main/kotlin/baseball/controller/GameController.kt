package baseball.controller

import baseball.domain.AnswerCreator
import baseball.domain.BallNumbers
import baseball.domain.BaseballGame
import baseball.domain.GameStatus
import baseball.view.InputView
import baseball.view.OutputView

class GameController(
        private val inputView: InputView,
        private val outputView: OutputView,
        private val answerCreator: AnswerCreator,
) {
    fun run() {
        // 1. 게임 생성
        val game = createGame()

        // 2. 게임 실행(정답 맞출 때까지)
        playRecursive(game)

        // 3.재실행 여부 입력 및 재실행 or 종료 결정
        if (GameStatus.REPLAY == inputView.inputNextGameStatus()) {
            run()
        }
    }

    private fun playRecursive(game: BaseballGame) {
        // 사용자가 추측한 숫자 입력
        val ballNumbers = BallNumbers(inputView.inputBallNumbers())
        // 정답과 비교 후 결과 반환
        val result = game.play(ballNumbers)

        // 결과 출력
        outputView.printResult(result)

        // 3스트라이크가 아닌 경우 재귀 호출
        if (result.strikeCount != 3) {
            playRecursive(game)
        }
    }

    private fun createGame(): BaseballGame {
        // 정답으로 사용할 3자리 랜덤 숫자 생성 및 반환
        val answer = answerCreator.create()
        return BaseballGame(answer)
    }
}