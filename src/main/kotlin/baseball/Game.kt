package baseball

import baseball.model.Answer
import baseball.model.Hint
import baseball.utils.RandomNumberGenerator
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.Console

class Game {

    private val outputView = OutputView()

    fun run() {
        println("숫자 야구 게임을 시작합니다.")
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
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val answer = Console.readLine()
        checkNextGameAnswer(answer)
        return answer == "1"
    }

    private fun checkNextGameAnswer(input: String) {
        if (input == "1" || input == "2") {
            return
        }
        throwIllegalException()
    }

    private fun throwIllegalException() {
        throw IllegalArgumentException("입력 값이 올바르지 않음")
    }
}