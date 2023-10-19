package baseball

import baseball.data.InputType
import camp.nextstep.edu.missionutils.Randoms

class GameHandler(private val io: IoHandler) {

    private val answer: MutableList<Int> = mutableListOf()

    fun init() {
        io.show(START_SENTENCE)
        var isKeepPlay = YES

        while (isKeepPlay == YES) {
            reset()
            playGame()

            io.show(AFTER_GAME_SENTENCE)
            isKeepPlay = io.getInput(InputType.AFTER_GAME).toInt()
        }
    }

    private fun reset() {
        answer.clear()

        while (answer.size < DIGIT) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (answer.contains(randomNumber).not()) {
                answer.add(randomNumber)
            }
        }
    }

    private fun playGame() {
        io.show(INPUT_SENTENCE)

        var inputNum = io.getInput(InputType.WHILE_GAME)
        while (checkIsCorrect(inputNum).not()) {
            io.show(INPUT_SENTENCE)
            inputNum = io.getInput(InputType.WHILE_GAME)
        }

        io.show(CLOSING_SENTENCE)
    }

    private fun checkIsCorrect(inputNum: String): Boolean {
        var ballCount = 0
        var strikeCount = 0

        inputNum.map {
            it.code - ASCII_0_CODE
        }.forEachIndexed { index, num ->
            if (answer[index] == num) {
                strikeCount++
            } else if (num in answer) {
                ballCount++
            }
        }

        if (ballCount == 0 && strikeCount == 0) {
            io.show(NOTHING_CORRECT_SENTENCE)
            return false
        }
        if (ballCount != 0) {
            io.show("${ballCount}볼 ")
        }
        if (strikeCount != 0) {
            io.show("${strikeCount}스트라이크")
        }
        io.show("\n")

        return strikeCount == 3
    }

    companion object {
        private const val DIGIT = 3
        private const val ASCII_0_CODE = 48
        private const val START_SENTENCE = "숫자 야구 게임을 시작합니다.\n"
        private const val INPUT_SENTENCE = "숫자를 입력해주세요 : "
        private const val NOTHING_CORRECT_SENTENCE = "낫싱\n"
        private const val CLOSING_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        private const val AFTER_GAME_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
        private const val YES = 1
    }
}