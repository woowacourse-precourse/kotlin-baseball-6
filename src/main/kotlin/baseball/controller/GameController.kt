package baseball.controller

import baseball.domain.BallNumbers
import baseball.domain.Computer
import baseball.domain.GameStatus
import baseball.domain.Guess
import baseball.view.InputView

class GameController(
    private val inputView: InputView,
    private val outputManager: OutputManager,
    private val computer: Computer,
) {
    fun run() {
        // 1. 게임 생성
        computer.createAnswer()

        // 2. 정답 맞출 때까지 사용자의 추측 입력 및 비교
        askUntilCorrectGuess(computer)

        // 3.재실행 여부 입력 및 재실행 or 종료 결정
        if (GameStatus.REPLAY == inputView.inputNextGameStatus()) {
            run()
        }
    }

    private fun askUntilCorrectGuess(computer: Computer) {
        // 사용자가 추측한 숫자 입력
        val guess = Guess(inputView.inputBallNumbers())
        // 정답과 비교 후 결과 반환
        val result = computer.checkGuess(guess)

        // 결과 출력
        outputManager.printResult(result)

        // 3스트라이크가 아닌 경우 재귀 호출
        if (result.strikeCount != BallNumbers.BALL_COUNT) {
            askUntilCorrectGuess(computer)
        }
    }

}