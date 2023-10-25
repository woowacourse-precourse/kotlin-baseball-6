package baseball

import camp.nextstep.edu.missionutils.Console

class UserInput : NumberProvider {

    override fun getNumberList(): List<Int> {
        try {
            print("숫자를 입력해주세요 : ")
            return Console.readLine().map { it.toString().toInt() }
                .apply { validate(this) }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닙니다.")
        } catch (e: IllegalArgumentException) {
            throw e
        }
    }

    private fun validate(userInput: List<Int>) {
        validateNumberLength(userInput)
        validateNumberInRange(userInput)
        validateNumberDuplicate(userInput)
    }

    private fun validateNumberDuplicate(userInput: List<Int>) {
        if (userInput.size != userInput.toSet().size) {
            throw IllegalArgumentException("중복된 숫자가 있습니다.")
        }
    }

    private fun validateNumberInRange(userInput: List<Int>) {
        userInput.forEach {
            if (it < START || it > END) {
                throw IllegalArgumentException("범위에 속하지 않은 숫자입니다.")
            }
        }
    }

    private fun validateNumberLength(userInput: List<Int>) {
        if (userInput.size != MAX_SIZE) {
            throw IllegalArgumentException("세 자리가 아닙니다.")
        }
    }

    companion object {
        private const val START = 1
        private const val END = 9
        private const val MAX_SIZE = 3
    }
}
