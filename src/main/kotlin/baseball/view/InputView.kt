package baseball.view

import baseball.validate.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        fun printGameStartMessage() {
            println("숫자 야구 게임을 시작합니다.")
        }

        fun inputUserNumbers(numberSize: Int): String {
            print("숫자를 입력해주세요 : ")
            val inputNumbers = Console.readLine()
            InputValidator.validateNumberFormat(inputNumbers)
            InputValidator.validateInputNumberSize(inputNumbers, numberSize)
            InputValidator.validateNumberDuplicate(inputNumbers)
            return inputNumbers
        }

        fun isReStart(): Boolean {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val restartInput = Console.readLine()
            InputValidator.validateNumberFormat(restartInput)
            InputValidator.validateInputNumberSize(restartInput, 1)
            return restartInput.toInt() == 1
        }

    }
}