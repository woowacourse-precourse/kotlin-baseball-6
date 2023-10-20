package baseball

import baseball.domain.AnswerGenerator
import baseball.config.GameCommandConfig.EXIT_CMD
import baseball.config.GameCommandConfig.RESTART_CMD
import baseball.config.GameNumberConfig.DIGIT_NUMBER
import baseball.domain.GameRestartHandler
import baseball.domain.NumberComparator
import baseball.domain.NumberValidator
import camp.nextstep.edu.missionutils.Console.readLine

class GameController {

    private val answerGenerator = AnswerGenerator()
    private val numberValidator = NumberValidator()
    private val numberComparator = NumberComparator()
    private val gameRestartHandler = GameRestartHandler()
    fun startGame() {
        println("숫자 야구 게임을 시작합니다.")
        do {
            startTurn()
            printEndMsg()
        } while (gameRestartHandler.restart(readLine()))
    }

    private fun startTurn() {
        val answer = answerGenerator.generate() // A. 컴퓨터는 사용자가 맞힐 정답을 생성한다.
        println(answer)

        while (true) {
            print("숫자를 입력해주세요 : ")
            val input = readLine() // B: 사용자의 수를 입력받는다.
            numberValidator.validate(input) // B-2 유효성 검증

            val result = numberComparator.compare(input, answer)  // C: 정답과 사용자의 입력을 비교해서 결과를 리턴받는다.
            println(result)
            if (result.strike == DIGIT_NUMBER) {
                break
            }
        }
    }

    private fun printEndMsg() {
        println("""${DIGIT_NUMBER}개의 숫자를 모두 맞히셨습니다! 게임 종료
                |게임을 새로 시작하려면 ${RESTART_CMD}, 종료하려면 ${EXIT_CMD}를 입력하세요.
            """.trimMargin())
    }

}