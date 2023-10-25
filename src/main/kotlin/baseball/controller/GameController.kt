package baseball.controller

import baseball.model.Answer
import baseball.model.ExitInput
import baseball.model.Hint
import baseball.utils.RandomNumberGenerator
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.Console

class GameController {

    private val outputView = OutputView()

    fun run() {
        outputView.printGameStart()
        while (true) {
            val computer = Answer(RandomNumberGenerator.generate(1, 9, 3))
            startGuessingAnswerUntilAllStrike(computer)
            outputView.printGameClear()

            if (isGameExit()) {
                break
            }
        }
        Console.close()
    }

    private fun startGuessingAnswerUntilAllStrike(computer: Answer) {
        while (true) {
            print("숫자를 입력해주세요 : ")
            val userAnswer = Answer(Console.readLine())
            if (isAllStrike(userAnswer, computer)) {
                return
            }
        }
    }

    private fun isAllStrike(input: Answer, computer: Answer): Boolean {
        val hint = Hint(computerAnswer = computer, userAnswer = input)
        outputView.printHint(hint)
        return hint.isAllStrike()
    }

    private fun isGameExit(): Boolean {
        val input = ExitInput(Console.readLine())
        return input.isExit()
    }
}