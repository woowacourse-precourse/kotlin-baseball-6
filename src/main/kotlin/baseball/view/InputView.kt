package baseball.view

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {
    fun readNumbers(): Int {
        print(INPUT_NUMBERS_PROMPT)
        return readLine().trim().toIntOrNull() ?: -1
    }


    companion object {
        private const val DELIMITER = " : "
        const val INPUT_NUMBERS_PROMPT = "숫자를 입력해주세요$DELIMITER"
    }
}