package baseball

import baseball.config.GameNumberConfig.DIGIT_NUMBER
import baseball.domain.AnswerGenerator
import baseball.domain.NumberComparator
import baseball.domain.NumberValidator
import baseball.view.InputCmdView
import baseball.view.InputNumberView
import baseball.view.OutputGuideView
import baseball.view.OutputResultView

class GameController {

    private val answerGenerator = AnswerGenerator()
    private val numberValidator = NumberValidator()
    private val numberComparator = NumberComparator()

    // view
    private val inputNumberView = InputNumberView()
    private val inputCmdView = InputCmdView()
    private val outputGuideView = OutputGuideView()
    private val outputResultView = OutputResultView()

    fun startGame() {
        outputGuideView.showStartMsg()
        do {
            startTurn()
            outputGuideView.showEndMsg()
        } while (inputCmdView())
    }

    private fun startTurn() {
        val answer = answerGenerator.generated() // A. 컴퓨터는 사용자가 맞힐 정답을 생성한다.
        println(answer)

        while (true) {
            val input = inputNumberView.inputNumber() // B: 사용자의 수를 입력받는다.
            numberValidator.validate(input) // B-2 유효성 검증

            val result = numberComparator.compare(input, answer)  // C: 정답과 사용자의 입력을 비교해서 결과를 리턴받는다.
            outputResultView.showResult(result) // C-2 결과 출력
            if (result.strike == DIGIT_NUMBER) {
                break
            }
        }
    }

}