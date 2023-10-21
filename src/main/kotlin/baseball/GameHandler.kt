package baseball

import baseball.data.GameNumDeck
import baseball.data.InputType

class GameHandler(private val io: IOHandler) {

    private lateinit var answer: GameNumDeck
    private var strikeCount = 0
    private var ballCount = 0

    fun start() {
        io.show(SENTENCE_FOR_START)
        var isKeepPlay = YES

        while (isKeepPlay == YES) {
            reset()
            playGame()

            io.show(SENTENCE_FOR_AFTER_GAME)
            isKeepPlay = io.getInput(InputType.AFTER_GAME).toInt()
        }
    }

    private fun reset() {
        answer = GameNumDeck.generateRandomDeck()
    }

    private fun playGame() {
        io.show(SENTENCE_FOR_INPUT)

        var inputString = io.getInput(InputType.WHILE_GAME)
        while (checkInputIsCorrect(inputString).not()) {
            io.show(SENTENCE_FOR_INPUT)
            inputString = io.getInput(InputType.WHILE_GAME)
        }

        io.show(SENTENCE_FOR_CLOSING)
    }

    private fun checkInputIsCorrect(inputString: String): Boolean {
        val nums = splitInputToNumber(inputString)
        strikeCount = 0
        ballCount = 0

        for ((index, num) in nums.withIndex()) {
            checkIsStrikeOrBall(index, num)
        }

        if (ballCount == 0 && strikeCount == 0) {
            io.show(SENTENCE_FOR_NOTHING_CORRECT)
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

    private fun splitInputToNumber(inputString: String): List<Int> {
        return inputString.map {
            it.code - ASCII_0_CODE
        }
    }

    private fun checkIsStrikeOrBall(index: Int, num: Int) {
        val numIndexAtAnswer = answer.nums.indexOf(num)
        if (numIndexAtAnswer == index) {
            strikeCount++
        } else if (numIndexAtAnswer != -1) {
            ballCount++
        }
    }

    companion object {
        private const val ASCII_0_CODE = 48
        private const val SENTENCE_FOR_START = "숫자 야구 게임을 시작합니다.\n"
        private const val SENTENCE_FOR_INPUT = "숫자를 입력해주세요 : "
        private const val SENTENCE_FOR_NOTHING_CORRECT = "낫싱\n"
        private const val SENTENCE_FOR_CLOSING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        private const val SENTENCE_FOR_AFTER_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
        private const val YES = 1
    }
}