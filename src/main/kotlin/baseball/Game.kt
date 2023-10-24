package baseball

import baseball.model.Answer
import baseball.model.Hint
import baseball.model.Validator
import baseball.utils.RandomNumberGenerator
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.Console

class Game {

    private val outputView = OutputView()

    fun run() {
        outputView.printGameStart()
        while (true) {
            val computer = Answer(RandomNumberGenerator.generate(1, 9, 3))
            startGuessingAnswer(computer)

            if (!playNextGame()) {
                break
            }
        }
    }

    private fun startGuessingAnswer(computer: Answer) {
        while (true) {
            print("숫자를 입력해주세요 : ")
            val userAnswer = Answer(Console.readLine())
            if (checkStrike(userAnswer, computer)) {
                return
            }
        }
    }

    private fun checkStrike(input: Answer, computer: Answer): Boolean {
        val hint = Hint(computerAnswer = computer, userAnswer = input)
        outputView.printHint(hint)
        return hint.isAllStrike()
    }

    private fun playNextGame(): Boolean {
        outputView.printGameClear()
        val answer = Console.readLine()
        Validator.validExitInput(answer)
        return answer == "1"
    }
}